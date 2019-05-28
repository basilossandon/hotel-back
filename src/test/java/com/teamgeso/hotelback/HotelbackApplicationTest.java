package com.teamgeso.hotelback;

import org.junit.Test;
import static org.junit.Assert.*;

import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.model.RoomType;

import java.time.LocalDateTime;

public class HotelbackApplicationTest {

    @Test
    public void main() {
        // System.out.println("Test complete");
    }

    @Test
    public void reservationTest(){
    	Integer id = 1;
    	Integer room_id = 2;
    	Double price = 10000.0;
    	String documentNumber = "1453241";
    	String checkInName = "Gabriel";
    	String code = "AX3400";
    	LocalDateTime now = LocalDateTime.now();
    	LocalDateTime tomorrow = now.plusDays(1);
    	Reservation reservation = new Reservation(id, now, tomorrow, price, documentNumber, checkInName, code, room_id);

    	assertEquals(reservation.getId(), id);
    	assertEquals(reservation.getStart(), now);
    	assertEquals(reservation.getEnd(), tomorrow);
    	assertEquals(reservation.getFinalPrice(), price, 0.001);
    	assertEquals(documentNumber, reservation.getDocumentNumber());
    	assertEquals(checkInName, reservation.getCheckinName());
    	assertEquals(code, reservation.getCode());
    	assertEquals(reservation.getRoomId(), room_id);
    }
}