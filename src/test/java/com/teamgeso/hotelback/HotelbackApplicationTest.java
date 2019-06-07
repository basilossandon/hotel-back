package com.teamgeso.hotelback;

import org.junit.Test;
import static org.junit.Assert.*;

import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.model.RoomType;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.dto.RoomTypeDTO;

import java.time.LocalDateTime;

public class HotelbackApplicationTest {

    // @Test
    // public void reservationModelTest(){
    // 	Integer id = 1;
    // 	Integer room_id = 2;
    // 	Double price = 10000.0;
    // 	String documentNumber = "1453241";
    // 	String checkInName = "Gabriel";
    // 	String code = "AX3400";
    // 	LocalDateTime now = LocalDateTime.now();
    // 	LocalDateTime tomorrow = now.plusDays(1);
    // 	Reservation reservation = new Reservation(id, now, tomorrow, price, documentNumber, checkInName, code, room_id);

    // 	assertEquals(reservation.getId(), id);
    // 	assertEquals(reservation.getStart(), now);
    // 	assertEquals(reservation.getEnd(), tomorrow);
    // 	assertEquals(reservation.getFinalPrice(), price, 0.001);
    // 	assertEquals(documentNumber, reservation.getDocumentNumber());
    // 	assertEquals(checkInName, reservation.getCheckinName());
    // 	assertEquals(code, reservation.getCode());
    // 	assertEquals(reservation.getRoomId(), room_id);
    // }

    // @Test
    // public void reservationModelTest2(){
    //     Integer id = 1;
    //     LocalDateTime now = LocalDateTime.now();
    //     LocalDateTime tomorrow = now.plusDays(1);
    //     Double price = 10000.0;
    //     String documentNumber = "1453241";
    //     String checkInName = "Gabriel";
    //     String code = "AX3400";
    //     Integer room_id = 2;
    //     Reservation reservation = new Reservation();

    //     reservation.setId(id);
    //     reservation.setStart(now);
    //     reservation.setEnd(tomorrow);
    //     reservation.setFinalPrice(price);
    //     reservation.setDocumentNumber(documentNumber);
    //     reservation.setCheckInName(checkInName);
    //     reservation.setCode(code);
    //     reservation.setRoomId(room_id);

    //     assertEquals(reservation.getId(), id);
    //     assertEquals(reservation.getStart(), now);
    //     assertEquals(reservation.getEnd(), tomorrow);
    //     assertEquals(reservation.getFinalPrice(), price, 0.001);
    //     assertEquals(documentNumber, reservation.getDocumentNumber());
    //     assertEquals(checkInName, reservation.getCheckinName());
    //     assertEquals(code, reservation.getCode());
    //     assertEquals(reservation.getRoomId(), room_id);
    // }
    
    // @Test    
    // public void roomModelTest(){
    //     Integer id = 1;
    //     Integer capacity = 2;
    //     Double price = 10000.0;
    //     Integer roomTypeId = 2;

    //     Room room = new Room(id, capacity, price, roomTypeId);

    //     assertEquals(room.getId(), id);
    //     assertEquals(room.getCapacity(), capacity);
    //     assertEquals(room.getPrice(), price, 0.001);
    //     assertEquals(room.getRoomTypeId(), roomTypeId);
    // }
    
    // @Test
    // public void roomModelTest2(){
    //     Integer id = 1;
    //     Integer capacity = 2;
    //     Double price = 10000.0;
    //     Integer roomTypeId = 2;

    //     Room room = new Room();
    //     room.setId(id);
    //     room.setCapacity(capacity);
    //     room.setPrice(price);
    //     room.setRoomTypeId(roomTypeId);

    //     assertEquals(room.getId(), id);
    //     assertEquals(room.getCapacity(), capacity);
    //     assertEquals(room.getPrice(), price, 0.001);
    //     assertEquals(room.getRoomTypeId(), roomTypeId);
    // }

    // @Test    
    // public void roomTypeModelTest(){
    //     Integer id = 1;
    //     String name = "Matrimonial";
    //     Double price = 100000.0;

    //     RoomType room = new RoomType(id, price, name);

    //     assertEquals(room.getId(), id);
    //     assertEquals(room.getName(), name);
    //     assertEquals(room.getPrice(), price, 0.001);
    // }

    // @Test    
    // public void roomTypeModelTest2(){
    //     Integer id = 1;
    //     String name = "Matrimonial";
    //     Double price = 100000.0;

    //     RoomType room = new RoomType();

    //     room.setId(id);
    //     room.setName(name);
    //     room.setPrice(price);

    //     assertEquals(room.getId(), id);
    //     assertEquals(room.getName(), name);
    //     assertEquals(room.getPrice(), price, 0.001);
    // }

    // @Test
    // public void reservationDTOModelTest(){
    //     LocalDateTime now = LocalDateTime.now();
    //     LocalDateTime tomorrow = now.plusDays(1);
    //     Double price = 10000.0;
    //     String documentNumber = "1453241";
    //     String checkInName = "Gabriel";
    //     String code = "AX3400";
    //     Integer room_id = 2;
    //     ReservationDTO reservation = new ReservationDTO();

    //     reservation.setStart(now);
    //     reservation.setEnd(tomorrow);
    //     reservation.setFinalPrice(price);
    //     reservation.setDocumentNumber(documentNumber);
    //     reservation.setCheckInName(checkInName);
    //     reservation.setCode(code);
    //     reservation.setRoomId(room_id);

    //     assertEquals(reservation.getStart(), now);
    //     assertEquals(reservation.getEnd(), tomorrow);
    //     assertEquals(reservation.getFinalPrice(), price, 0.001);
    //     assertEquals(documentNumber, reservation.getDocumentNumber());
    //     assertEquals(checkInName, reservation.getCheckInName());
    //     assertEquals(code, reservation.getCode());
    //     assertEquals(reservation.getRoomId(), room_id);
    // }

    // @Test
    // public void roomDTOModelTest(){
    //     Integer capacity = 2;
    //     Double price = 10000.0;
    //     Integer roomTypeId = 2;

    //     RoomDTO room = new RoomDTO();
    //     room.setCapacity(capacity);
    //     room.setPrice(price);
    //     room.setRoomTypeId(roomTypeId);

    //     assertEquals(room.getCapacity(), capacity);
    //     assertEquals(room.getPrice(), price, 0.001);
    //     assertEquals(room.getRoomTypeId(), roomTypeId);
    // }

    // @Test
    // public void roomTypeDTOModelTest(){
    //     Double price = 100000.0;
    //     String name = "Matrimonial";

    //     RoomTypeDTO room = new RoomTypeDTO();
    //     room.setPrice(price);
    //     room.setName(name);

    //     assertEquals(room.getPrice(), price, 0.001);
    //     assertEquals(room.getName(), name);
    // }
}