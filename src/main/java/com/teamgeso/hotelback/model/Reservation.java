package com.teamgeso.hotelback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "start", nullable = false)
    private LocalDateTime start;
    @Column(name = "end", nullable = false)
    private LocalDateTime end;
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    @Column(name = "checkin_name", nullable = false)
    private String checkInName;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "room_id", nullable = false)    
    private Integer roomId;
    @Column(name = "bill_id", nullable = true)
    private Integer billId;

    @OneToMany(
        mappedBy = "reservation",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Member> members = new ArrayList<>();
    

    public Reservation( Integer id,
                        LocalDateTime start,
                        LocalDateTime end,
                        String documentNumber,
                        String checkInName,
                        String code,
                        String email){
        this.id = id;
        this.start = start;
        this.end = end;
        this.documentNumber = documentNumber;
        this.checkInName = checkInName;
        this.code = code;
        this.email= email;
    }

    public Reservation(){
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    public String getDocumentNumber(){
        return this.documentNumber;
    }
    public void setDocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
    }
    public String getCheckInName(){
        return this.checkInName;
    }
    public void setCheckInName(String checkInName){
        this.checkInName = checkInName;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Integer getRoomId(){
        return this.roomId;
    }
    public void setRoomId(Integer roomId){
        this.roomId = roomId;
    }
    public Integer getBillId(){
        return this.billId;
    }
    public void setBillId(Integer billId){
        this.billId = billId;
    }
    public List<Member> getMembers(){
        return this.members;
    }
    public void setMembers(List<Member> members){
        this.members = members;
    }
}



