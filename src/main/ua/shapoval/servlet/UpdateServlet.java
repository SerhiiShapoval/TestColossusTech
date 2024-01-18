package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.error.WarehouseNotFoundException;
import main.ua.shapoval.model.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Warehouse updatedWarehouse = objectMapper.readValue(req.getReader(), Warehouse.class);
            warehouseDao.update(updatedWarehouse, id);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
       catch (WarehouseNotFoundException e){

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        } catch (RuntimeException e){

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}