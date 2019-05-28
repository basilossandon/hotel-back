package com.teamgeso.hotelback.dto;

public class RoomTypeDTO {
    private String name;
    private Double price;


    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name) {
        this.name = name;
    }
}
