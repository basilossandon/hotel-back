package com.teamgeso.hotelback.model;

import javax.persistence.*;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="member")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    // private String documentNumber
    // @Column(name = "bill_id", nullable = false)
    // private Integer billId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Member(Integer id, String name, /*Integer billId,*/ Reservation reservation){
        this.id = id;
        this.name = name;
        // this.billId = billId;
        this.reservation = reservation;
    }

    public Member(){
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    // public Integer getBillId(){
    //     return this.billId;
    // }

    // public void setBillId(Integer billId){
    //     this.billId = billId;
    // }

    public Reservation getReservation(){
        return this.reservation;
    }

    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }


}