package com.teamgeso.hotelback.dto;

import java.time.LocalDateTime;

public class ReservationDTO {
    private LocalDateTime start;
    private LocalDateTime end;
    private double final_price;
    private String document_number;
    private String checkInName;
    private String code;
    private Integer room_id;

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
    	return this.final_price;
    }

    public void setFinalPrice(double final_price){
        this.final_price = final_price;
    }

    public String getDocumentNumber(){
    	return this.document_number;
	}

    public void setDocumentNumber(String document_number){
    	this.document_number = document_number;
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
    	return this.room_id;
	}

    public void setRoomId(Integer room_id){
    	this.room_id = room_id;
	}
}
