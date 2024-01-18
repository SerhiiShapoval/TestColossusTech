package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.error.WarehouseNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetServlet", urlPatterns = "/get")
public class GetServlet extends HttpServlet {

    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
           String response = objectMapper.writeValueAsString(warehouseDao.get(id));
           resp.setContentType("application/json");
           resp.getWriter().write(response);
            resp.setStatus(HttpServletResponse.SC_OK);

        }catch (WarehouseNotFoundException e){

            resp.getWriter().write(e.getMessage());

            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (RuntimeException e){

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }
}
