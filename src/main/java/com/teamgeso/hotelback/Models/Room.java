package com.teamgeso.hotelback.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Room {
    private int roomId;
    private String type;
    private Integer capacity;
    private Double price;
    private int roomTypeId;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "roomType_id")
    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId &&
                roomTypeId == room.roomTypeId &&
                Objects.equals(type, room.type) &&
                Objects.equals(capacity, room.capacity) &&
                Objects.equals(price, room.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, type, capacity, price, roomTypeId);
    }
}
