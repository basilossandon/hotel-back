package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "room_type_id", nullable = false)
    private Integer roomTypeId;

    public Room(Integer id,
                Integer  capacity,
                Double  price,
                Integer  roomTypeId){
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.roomTypeId = roomTypeId;
    }

    public Room(){
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRoomTypeId() {
        return this.roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

}
