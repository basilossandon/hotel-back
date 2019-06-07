package com.teamgeso.hotelback.dto;

public class RoomTypeDTO {
    private String name;
    private Double price;
    private Integer capacity;

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

    public Integer getCapacity(){
        return this.capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }
}
