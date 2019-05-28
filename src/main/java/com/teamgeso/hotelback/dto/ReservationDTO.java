package com.teamgeso.hotelback.dto;

import java.time.LocalDateTime;

public class ReservationDTO {
    private LocalDateTime start;
    private LocalDateTime end;
    private double finalPrice;
    private String documentNumber;
    private String checkInName;
    private String code;
    private Integer roomId;

    public LocalDateTime getStart() {
        return this.start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return this.end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public double getFinalPrice() {
    	return this.finalPrice;
    }

    public void setFinalPrice(double final_price){
        this.finalPrice = finalPrice;
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

    public Integer getRoomId(){
    	return this.roomId;
	}

    public void setRoomId(Integer roomId){
    	this.roomId = roomId;
	}
}
