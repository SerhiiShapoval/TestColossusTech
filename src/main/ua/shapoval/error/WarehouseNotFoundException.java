package main.ua.shapoval.error;

public class WarehouseNotFoundException extends RuntimeException {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public WarehouseNotFoundException(String error) {
        this.error = error;
    }
}
