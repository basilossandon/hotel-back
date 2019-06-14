package com.teamgeso.hotelback.dto;
public class RoomDTO {
    private Double price;
    private Integer capacity;
    private String type;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
