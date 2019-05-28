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
        System.out.println("Test complete");
    }

    @Test
    public void reservationTest(){
    	LocalDateTime now = LocalDateTime.now();
    	LocalDateTime tomorrow = now.plusDays(1);
    	Reservation reservation = new Reservation(1, now, tomorrow, 10000.0, "1453241", "Gabriel", "AX3400", 2);

    	if (reservation.getId() != 1 && 
    		! reservation.getStart().equals(now) &&
    		! reservation.getEnd().equals(tomorrow) &&
    		reservation.getFinalPrice() != 10000.0 &&
    		! reservation.getDocumentNumber().equals("1453241") &&
    		! reservation.getCheckinName().equals("Gabriel") &&
    		! reservation.getCode().equals("AX3400") &&
    		reservation.getRoomId() != 2) {

    		fail("Reservation model not working properly.");
    	}
    }
}