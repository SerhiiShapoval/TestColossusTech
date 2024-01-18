package main.ua.shapoval.dao;

import main.ua.shapoval.error.WarehouseNotFoundException;
import main.ua.shapoval.util.DataBaseManager;
import main.ua.shapoval.model.Warehouse;
import main.ua.shapoval.util.SqlQuery;
import main.ua.shapoval.dto.WarehouseFilter;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WarehouseDaoImpl implements WarehouseDao {
    private final DataBaseManager dataBaseManager = new DataBaseManager();


    @Override
    public void save(Warehouse warehouse) {
        try(PreparedStatement preparedStatement =
                    dataBaseManager.getConnection().prepareStatement(SqlQuery.SAVE.name())) {
            preparedStatement.setString(1, warehouse.getName());
            preparedStatement.setString(2, warehouse.getAddressLine1());
            preparedStatement.setString(3, warehouse.getAddressLine2());
            preparedStatement.setString(4, warehouse.getCity());
            preparedStatement.setString(5, warehouse.getState());
            preparedStatement.setString(6, warehouse.getCountry());
            preparedStatement.setInt(7, warehouse.getInventoryQuantity());
           int result =  preparedStatement.executeUpdate();
           if (result > 0){
               System.out.println(" A new warehouse was created successfully ");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Warehouse warehouse, int id) {
        checkId(id);
        try(PreparedStatement preparedStatement =
                    dataBaseManager.getConnection().prepareStatement(SqlQuery.UPDATE_BY_ID.name())) {
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            if (result > 0){
                System.out.println(" A warehouse was updated successfully ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        checkId(id);
        try(PreparedStatement preparedStatement =
                    dataBaseManager.getConnection().prepareStatement(SqlQuery.DELETE_BY_ID.name())) {
            preparedStatement.setInt(1,id);
           int result = preparedStatement.executeUpdate();
            if (result > 0){
                System.out.println(" Delete warehouse whit id = " + id + " successfully ");
            }else {
                throw new WarehouseNotFoundException(" Warehouse with " + id + " not found ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse get(int id) {
        checkId(id);
        try(PreparedStatement preparedStatement =
                    dataBaseManager.getConnection().prepareStatement(SqlQuery.GET_BY_ID.name())){
            preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
               Warehouse warehouse = new Warehouse();
               warehouse.setName(resultSet.getString("name"));
               warehouse.setAddressLine1(resultSet.getString("address_line_1"));
               warehouse.setAddressLine2(resultSet.getString("address_line_2"));
               warehouse.setCity(resultSet.getString("city"));
               warehouse.setState(resultSet.getString("state"));
               warehouse.setCountry(resultSet.getString("country"));
               warehouse.setInventoryQuantity(resultSet.getInt("inventory_quantity"));
               return warehouse;
           } else {
               throw new WarehouseNotFoundException(" Warehouse with " + id + " not found ");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List<Warehouse> getAllByFilter(WarehouseFilter filter) {

        List<Warehouse> warehouseList = new ArrayList<>();
        String sql =  "SELECT * FROM warehouse WHERE "
                + "name LIKE ? AND "
                + "address_line_1 LIKE ? AND "
                + "city LIKE ?  AND "
                + "state LIKE ? AND "
                + "country LIKE ? AND "
                + "inventory_quantity >= ? "
                + "ORDER BY " + ((filter.getOrderBy() == null)?"id":filter.getOrderBy()) + " LIMIT ? OFFSET ?";
        try (PreparedStatement preparedStatement =
                     dataBaseManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, filter.getName() + "%" );
            preparedStatement.setString(2,  filter.getAddress() + "%" );
            preparedStatement.setString(3,filter.getCity() + "%" );
            preparedStatement.setString(4, filter.getState() + "%" );
            preparedStatement.setString(5, filter.getCountry() + "%" );
            preparedStatement.setInt(6, (filter.getQuantity() == null)? 0 : filter.getQuantity());
            preparedStatement.setInt(7, (filter.getLimit() == null) ? 100_00 : filter.getLimit());
            preparedStatement.setInt(8, (filter.getOffset() == null) ? 0 : filter.getOffset());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setName(resultSet.getString("name"));
                warehouse.setAddressLine1(resultSet.getString("address_line_1"));
                warehouse.setAddressLine2(resultSet.getString("address_line_2"));
                warehouse.setCity(resultSet.getString("city"));
                warehouse.setState(resultSet.getString("state"));
                warehouse.setCountry(resultSet.getString("country"));
                warehouse.setInventoryQuantity(resultSet.getInt("inventory_quantity"));

                warehouseList.add(warehouse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return warehouseList;
    }
    private void checkId(int id){
        if(id <= 0) {
            throw new RuntimeException(" Id must be greater then 0 ");
        }

    }
}

