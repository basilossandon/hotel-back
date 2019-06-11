package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="service")
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name="room_service",
            joinColumns={@JoinColumn(name="room_id")},
            inverseJoinColumns={@JoinColumn(name="service_id")})
    private Set<Room> rooms =new HashSet<>();

    public Service(Integer id,
                Double  price,
                String  name){
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Service(){
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

    public Set<Room> getRooms(){
        return this.rooms;
    }
    
    public void setRooms(Set<Room> rooms){
        this.rooms = rooms;
    }
}
