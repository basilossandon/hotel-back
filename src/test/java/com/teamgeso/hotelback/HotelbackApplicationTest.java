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
    	LocalDateTime now = LocalDateTime.now();
    	LocalDateTime tomorrow = now.plusDays(1);
    	Reservation reservation = new Reservation(id, now, tomorrow, 10000.0, "1453241", "Gabriel", "AX3400", room_id);

    	assertEquals(reservation.getId(), id);
    	assertEquals(reservation.getStart(), now);
    	assertEquals(reservation.getEnd(), tomorrow);
    	assertEquals(reservation.getFinalPrice(), 10000.0, 0.001);
    	assertEquals(reservation.getDocumentNumber(), "1453241");
    	assertEquals(reservation.getCheckinName(), "Gabriel");
    	assertEquals(reservation.getCode(), "AX3400");
    	assertEquals(reservation.getRoomId(), room_id);
    }
}