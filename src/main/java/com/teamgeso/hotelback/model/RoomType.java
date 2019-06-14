package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="room_type")
public class RoomType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;



    public RoomType(Integer id,
                    Double  price,
                    Integer capacity,
                    String  name){
        this.id = id;
        this.price = price;
        this.name = name;
        this.capacity = capacity;
    }

    public RoomType(){
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

}
