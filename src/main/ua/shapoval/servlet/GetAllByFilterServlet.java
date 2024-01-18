package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.dto.ResponseDto;
import main.ua.shapoval.dto.WarehouseFilter;
import main.ua.shapoval.model.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFilterServlet", urlPatterns = "/filter")
public class GetAllByFilterServlet extends HttpServlet {

    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto responseDto = new ResponseDto();
        WarehouseFilter warehouseFilter = objectMapper.readValue(req.getReader(), WarehouseFilter.class);
        List<Warehouse> list = warehouseDao.getAllByFilter(warehouseFilter);
        responseDto.setList(list);
        responseDto.setCount(list.size());
        String result = objectMapper.writeValueAsString(responseDto);
        resp.setContentType("application/json");
        resp.getWriter().write(result);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
