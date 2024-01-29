package main.ua.shapoval.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.ua.shapoval.dao.WarehouseDao;
import main.ua.shapoval.dao.WarehouseDaoImpl;
import main.ua.shapoval.dto.Response;
import main.ua.shapoval.dto.ResponseFilterDto;
import main.ua.shapoval.dto.WarehouseFilter;
import main.ua.shapoval.error.WarehouseNotFoundException;
import main.ua.shapoval.model.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = "/warehouses/*")
public class WarehouseServlet extends HttpServlet {
    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse request = objectMapper.readValue(req.getReader(), Warehouse.class);

        Warehouse insertedWarehouse = warehouseDao.save(request);

        Response<Warehouse> response = new Response<>(insertedWarehouse,
                req.getRequestURI() + "/" + insertedWarehouse.getId());

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(objectMapper.writeValueAsString(response));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Warehouse updatedWarehouse =
                    warehouseDao.update(objectMapper.readValue(req.getReader(), Warehouse.class),id);

            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(objectMapper.writeValueAsString(updatedWarehouse));

        } catch (WarehouseNotFoundException e) {

            resp.getWriter().write(e.getError());
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        } catch (RuntimeException e) {

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("id") != null){
                int id = Integer.parseInt(req.getParameter("id"));

                String response = objectMapper.writeValueAsString(warehouseDao.get(id));

                resp.getWriter().write(response);

            }else {
                ResponseFilterDto responseFilterDto = new ResponseFilterDto();

                WarehouseFilter warehouseFilter = getParameters(req);

                List<Warehouse> list = warehouseDao.getAllByFilter(warehouseFilter);
                responseFilterDto.setList(list);
                responseFilterDto.setCount(list.size());
                String result = objectMapper.writeValueAsString(responseFilterDto);

                resp.getWriter().write(result);

            }
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (WarehouseNotFoundException e) {

            resp.getWriter().write(e.getError());
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        } catch (RuntimeException e) {

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            int id = Integer.parseInt(req.getParameter("id"));

            warehouseDao.delete(id);

            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (WarehouseNotFoundException e) {

            resp.getWriter().write(e.getError());
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        } catch (RuntimeException e) {

            resp.getWriter().write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }
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
