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
    private Integer room_type_id;

    public Room(Integer id,
                Integer  capacity,
                Double  price,
                Integer  room_type_id){
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.room_type_id = room_type_id;
    }

    public Room(){
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }

}
