package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.dto.ResponseFilterDto;
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
        ResponseFilterDto responseFilterDto = new ResponseFilterDto();

        WarehouseFilter warehouseFilter = getParameters(req);
        System.out.println(warehouseFilter.toString());
        List<Warehouse> list = warehouseDao.getAllByFilter(warehouseFilter);
        responseFilterDto.setList(list);
        responseFilterDto.setCount(list.size());
        String result = objectMapper.writeValueAsString(responseFilterDto);
        resp.setContentType("application/json");
        resp.getWriter().write(result);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private WarehouseFilter getParameters(HttpServletRequest request){

        return new WarehouseFilter(request.getParameter("name")
                , request.getParameter("address")
                , request.getParameter("city")
                , request.getParameter("state")
                , request.getParameter("country")
                , Integer.parseInt( request.getParameter("quantity"))
                , request.getParameter("orderBy")
                , Integer.parseInt( request.getParameter("limit"))
                , Integer.parseInt(request.getParameter("offset")));
    }
}
