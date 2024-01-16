package main.ua.shapoval.dao;

import main.ua.shapoval.model.Warehouse;

import java.util.Optional;


public interface WarehouseDao {
   Optional<Warehouse> get(int id);
    void save(Warehouse warehouse);

    void update(Warehouse warehouse);

    void delete(int id);
}
