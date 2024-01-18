package main.ua.shapoval.dao;

import main.ua.shapoval.model.Warehouse;
import main.ua.shapoval.dto.WarehouseFilter;

import java.util.List;


public interface WarehouseDao {
   Warehouse get(int id);
    void save(Warehouse warehouse);

    void update(Warehouse warehouse, int id);

    void delete(int id);
    List<Warehouse> getAllByFilter(WarehouseFilter filter);
}
