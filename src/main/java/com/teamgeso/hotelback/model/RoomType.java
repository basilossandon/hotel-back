package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="room_type")
public class RoomType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;



    public RoomType(Integer id,
                    Double  price,
                    String  name){
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public RoomType(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {return this.price;}

    public void setPrice(double price) {this.price = price;}

    public String getName() {return this.name;}

    public void setName( String name) { this.name = name;}

}
