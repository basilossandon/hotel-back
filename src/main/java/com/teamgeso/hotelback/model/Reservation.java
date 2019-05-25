package com.teamgeso.hotelback.model;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity

@Table(name = "reservation")

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "start", nullable = false)
    private LocalDateTime start;
    @Column(name = "end", nullable = false)
    private LocalDateTime end;
    @Column(name = "final_price", nullable = false)
    private double final_price;
    @Column(name = "document_number", nullable = false)
    private String document_number;
    @Column(name = "checkin_name", nullable = false)
    private String checkin_name;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "room_id", nullable = false)
    private Integer room_id;


    public Reservation( Integer id,
                        LocalDateTime start,
                        LocalDateTime end,
                        double  final_price,
                        String document_number,
                        String checkin_name,
                        String code,
                        Integer room_id){
        this.id = id;
        this.start = start;
        this.end = end;
        this.final_price= final_price;
        this.document_number = document_number;
        this.checkin_name = checkin_name;
        this.code = code;
        this.room_id = room_id;
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
        this.start = start;}

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public double getFinal_price() { return this.final_price; }

    public void setFinal_price(double final_price){
        this.final_price = final_price;
    }

    public String getDocument_number(){ return this.document_number;}

    public void setDocument_number(String document_number){this.document_number = document_number;}

    public String getCheckin_name(){return this.checkin_name;}

    public void setCheckin_name(String checkin_name){this.checkin_name = checkin_name;}

    public String getCode(){return this.code;}

    public void setCode(String code){this.code = code;}

    public Integer getRoom_id(){return this.room_id;}

    public void setRoom_id(Integer room_id){this.room_id= room_id;}
}



