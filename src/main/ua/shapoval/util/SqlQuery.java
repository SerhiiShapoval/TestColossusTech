package main.ua.shapoval.util;

public enum SqlQuery {

    GET_BY_ID(
            " SELECT * FROM warehouse WHERE id = ?"),
    DELETE_BY_ID(" DELETE FROM warehouse WHERE id = ?"),
    UPDATE_BY_ID("UPDATE warehouse SET name = ?, address_line_1 = ?, address_line_2 = ?, city = ?, state = ?, " +
            "country = ?, inventory_quantity = ? WHERE id = ?"),
    SAVE("INSERT INTO warehouse (name, address_line_1, address_line_2, city, state, country, inventory_quantity) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
    private final String query;

    public String getQuery() {
        return query;
    }

    SqlQuery(String query) {
        this.query = query;
    }




}
