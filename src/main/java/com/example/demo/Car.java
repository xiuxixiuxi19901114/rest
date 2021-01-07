package com.example.demo;

public class Car {
    private String brand;
    private String orderId;
    private String bookState;

    public Car(String brand, String orderId, String bookState) {
        this.brand = brand;
        this.orderId = orderId;
        this.bookState = bookState;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState;
    }
}
