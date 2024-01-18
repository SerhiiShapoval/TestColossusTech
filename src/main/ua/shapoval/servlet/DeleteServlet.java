package main.ua.shapoval.servlet;


import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            warehouseDao.delete(id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (RuntimeException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
