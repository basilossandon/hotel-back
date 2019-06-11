package com.teamgeso.hotelback.dto;

public class ServiceDTO {
    private String name;
    private Double price;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name) {
        this.name = name;
    }
}
