package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnore
    private Set<Service> services = new HashSet<>();

    public Room(Integer id,
                Integer capacity,
                String type){
        this.id = id;
        this.capacity = capacity;
        this.type = type;
    }

    public Room(){
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

    public Set<Service> getServices(){
        return this.services;
    }

    public void setServices(Set<Service> services){
        this.services = services;
    }
}
