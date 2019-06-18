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
    @Column(name = "document_number", nullable = false)
    private String documentNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Member(Integer id, String name, String documentNumber, Reservation reservation){
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
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

    public String getDocumentNumber(){
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
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