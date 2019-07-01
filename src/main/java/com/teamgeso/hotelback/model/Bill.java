package com.teamgeso.hotelback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "service_string", nullable = true)
    private String serviceString;

    @ManyToMany(mappedBy = "bills")
    @JsonIgnore
    private Set<Service> services = new HashSet<>();

    public Bill(Integer id,
                Integer roomId,
                String serviceString,
                Set<Service> services){
        this.id = id;
        this.roomId = roomId;
        this.serviceString = serviceString;
        this.services = services;
    }

    public Bill(){
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getServiceString(){
        return this.serviceString;
    }

    public void setServiceString(String serviceString){
        this.serviceString = serviceString;
    }

    public Set<Service> getServices(){
        return this.services;
    }

    public void setServices(Set<Service> services){
        this.services = services;
    }
}
