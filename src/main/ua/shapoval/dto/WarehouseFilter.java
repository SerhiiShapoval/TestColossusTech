package main.ua.shapoval.dto;

import java.io.Serializable;

public class WarehouseFilter implements Serializable {
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private Integer quantity;
    private String orderBy;


    private Integer limit;
    private Integer offset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public WarehouseFilter() {
    }

    public WarehouseFilter(String name, String address, String city, String state, String country, Integer quantity,
                           String orderBy, Integer limit, Integer offset) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.quantity = quantity;
        this.orderBy = orderBy;
        this.limit = limit;
        this.offset = offset;
    }
}
