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
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "country", nullable = false)
    private String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Member(Integer id, 
                  String name, 
                  String documentNumber, 
                  Integer age, 
                  String country, 
                  Reservation reservation){
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.age = age;
        this.country = country;
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

    public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getCountry(){
        return this.country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public Reservation getReservation(){
        return this.reservation;
    }

    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }

    // public Integer getBillId(){
    //     return this.billId;
    // }

    // public void setBillId(Integer billId){
    //     this.billId = billId;
    // }
}