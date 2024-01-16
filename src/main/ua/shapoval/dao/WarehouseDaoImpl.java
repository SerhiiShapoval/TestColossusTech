package main.ua.shapoval.dao;

import main.ua.shapoval.DataBaseManager;
import main.ua.shapoval.model.Warehouse;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class WarehouseDaoImpl implements WarehouseDao {
    private DataBaseManager dataBaseManager;


    @Override
    public void save(Warehouse warehouse) {
        String insertSql = "INSERT INTO warehouse (name, address_line_1, address_line_2, city, state, country, inventory_quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = dataBaseManager.getConnection().prepareStatement(insertSql)) {
            preparedStatement.setString(1, warehouse.getName());
            preparedStatement.setString(2, warehouse.getAddressLine1());
            preparedStatement.setString(3, warehouse.getAddressLine2());
            preparedStatement.setString(4, warehouse.getCity());
            preparedStatement.setString(5, warehouse.getState());
            preparedStatement.setString(6, warehouse.getCountry());
            preparedStatement.setInt(7, warehouse.getInventoryQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Warehouse warehouse) {
        String updateSql = " UPDATE warehouse SET "
        try(PreparedStatement preparedStatement = dataBaseManager.getConnection().prepareStatement()) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String deleteSql = " DELETE FROM warehouse WHERE id = ?";
        try(PreparedStatement preparedStatement = dataBaseManager.getConnection().prepareStatement(deleteSql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Warehouse> get(int id) {
        return Optional.empty();
    }
}
