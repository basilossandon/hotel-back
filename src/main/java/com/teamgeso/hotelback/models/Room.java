package com.teamgeso.hotelback.models;

import javax.persistence.*;

@Entity
@Table(name="room")
@IdClass(RoomPK.class)
public class Room {
    private int id;
    private Integer capacity;
    private Double price;
    private int roomTypeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Id
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

        if (id != room.id) return false;
        if (roomTypeId != room.roomTypeId) return false;
        if (capacity != null ? !capacity.equals(room.capacity) : room.capacity != null) return false;
        if (price != null ? !price.equals(room.price) : room.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + roomTypeId;
        return result;
    }
}
