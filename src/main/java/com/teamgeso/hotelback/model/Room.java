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
    @Column(name = "room_id", nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "room_type_id", nullable = false)
    private Integer roomTypeId;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Room(Integer id,
                Double  price,
                Integer  roomTypeId){
        this.id = id;
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

    public Set<Reservation> getReservations(){
        return this.reservations;
    }

    public void setReservations(Set<Reservation> reservations){
        this.reservations = reservations;
    }

}
