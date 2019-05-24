package com.teamgeso.hotelback.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RoomType {
    private int roomTypeId;
    private Double price;
    private String typeName;

    @Id
    @Column(name = "roomType_id")
    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
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
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return roomTypeId == roomType.roomTypeId &&
                Objects.equals(price, roomType.price) &&
                Objects.equals(typeName, roomType.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomTypeId, price, typeName);
    }
}
