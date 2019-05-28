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
    private double finalPrice;
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    @Column(name = "checkin_name", nullable = false)
    private String checkInName;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "room_id", nullable = false)
    private Integer roomId;


    public Reservation( Integer id,
                        LocalDateTime start,
                        LocalDateTime end,
                        double  finalPrice,
                        String documentNumber,
                        String checkInName,
                        String code,
                        Integer roomId){
        this.id = id;
        this.start = start;
        this.end = end;
        this.finalPrice= finalPrice;
        this.documentNumber = documentNumber;
        this.checkInName = checkInName;
        this.code = code;
        this.roomId = roomId;
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
    public double getFinalPrice() {
        return this.finalPrice;
    }
    public void setFinalPrice(double finalPrice){
        this.finalPrice = finalPrice;
    }
    public String getDocumentNumber(){
        return this.documentNumber;
    }
    public void setDocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
    }
    public String getCheckinName(){
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
    public Integer getRoomId(){
        return this.roomId;
    }
    public void setRoomId(Integer roomId){
        this.roomId= roomId;
    }
}



