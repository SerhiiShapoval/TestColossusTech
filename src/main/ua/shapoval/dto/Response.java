package main.ua.shapoval.dto;

public class Response<T> {
    T data;
    String location;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Response(T data, String location) {
        this.data = data;
        this.location = location;
    }
}
