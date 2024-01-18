package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.model.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveServlet" ,urlPatterns = "/create")
public class SaveServlet extends HttpServlet {
    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = objectMapper.readValue(req.getReader(), Warehouse.class);
        warehouseDao.save(warehouse);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}