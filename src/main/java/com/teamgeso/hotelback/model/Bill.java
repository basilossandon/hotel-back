package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @ManyToMany(mappedBy = "bills")
    @JsonIgnore
    private Set<Service> services = new HashSet<>();

    public Bill(Integer id,
                Integer roomId,
                Set<Service> services){
        this.id = id;
        this.services = services;
        this.roomId = roomId;
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

    public Set<Service> getServices(){
        return this.services;
    }

    public void setServices(Set<Service> services){
        this.services = services;
    }
}
