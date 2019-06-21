package com.teamgeso.hotelback;

import org.junit.Test;
import static org.junit.Assert.*;

import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.model.Service;
import com.teamgeso.hotelback.model.Bill;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.dto.RoomDTO;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

public class HotelbackApplicationTest {

     @Test
     public void reservationModelTest(){
     	Integer id = 1;
     	
     	
     	String documentNumber = "1453241";
     	String checkInName = "Gabriel";
     	String code = "AX3400";
        String email = "gabriel@usach.cl";
     	LocalDateTime now = LocalDateTime.now();
     	LocalDateTime tomorrow = now.plusDays(1);
     	Reservation reservation = new Reservation(id, now, tomorrow, documentNumber, checkInName, code, email);

     	assertEquals(reservation.getId(), id);
     	assertEquals(reservation.getStart(), now);
     	assertEquals(reservation.getEnd(), tomorrow);
     	
     	assertEquals(documentNumber, reservation.getDocumentNumber());
     	assertEquals(checkInName, reservation.getCheckInName());
        assertEquals(code, reservation.getCode());
        assertEquals(email,reservation.getEmail());
     	
     }

     @Test
    public void reservationModelTest2(){
         Integer id = 2;
         LocalDateTime now = LocalDateTime.now();
         LocalDateTime tomorrow = now.plusDays(1);
         
         String documentNumber = "1453241";
         String checkInName = "Gabriel";
         String code = "AX3400";
         String email="gabriel@usahc.cl";
         Reservation reservation = new Reservation();

         reservation.setId(id);
         reservation.setStart(now);
         reservation.setEnd(tomorrow);
         
         reservation.setDocumentNumber(documentNumber);
         reservation.setCheckInName(checkInName);
         reservation.setCode(code);
         reservation.setEmail(email);
         //setEmail

         assertEquals(reservation.getId(), id);
         assertEquals(reservation.getStart(), now);
         assertEquals(reservation.getEnd(), tomorrow);
         
         assertEquals(documentNumber, reservation.getDocumentNumber());
         assertEquals(checkInName, reservation.getCheckInName());
         assertEquals(code, reservation.getCode());
         assertEquals(email,reservation.getEmail());
     }
    
     @Test    
     public void roomModelTest(){
         Integer id = 1;
         Integer capacity = 2;
         
         String type = "Doble";

         Room room = new Room(id, capacity,type);

         assertEquals(room.getId(), id);
         assertEquals(room.getCapacity(), capacity);
         
         assertEquals(room.getType(), type);
     }
    
     @Test
     public void roomModelTest2(){
         Integer id = 2;
         Integer capacity = 2;
         Double price = 10000.0;
         String roomTypeId = "Matrimonial";

         Room room = new Room();
         room.setId(id);
         room.setCapacity(capacity);
         room.setPrice(price);
         room.setType(roomTypeId);

         assertEquals(room.getId(), id);
         assertEquals(room.getCapacity(), capacity);
         assertEquals(room.getPrice(), price, 0.001);
         assertEquals(room.getType(), roomTypeId);
     }
     @Test 
     public void billModelTest(){
         Integer id =1;
         Integer roomId= 1;
         Set<Service> services = new HashSet<>();
        Bill bill= new Bill(id,roomId,services);
        assertEquals(id, bill.getId());
        assertEquals(roomId, bill.getRoomId());
        assertEquals(services, bill.getServices());
     }
     @Test 
     public void billModelTest2(){
         Integer id =2;
         Integer roomId= 2;
         Set<Service> services = new HashSet<>();
        Bill bill= new Bill();
        bill.setId(id);
        bill.setRoomId(roomId);
        bill.setServices(services);
        assertEquals(id, bill.getId());
        assertEquals(roomId, bill.getRoomId());
        assertEquals(services, bill.getServices());
     }
     @Test 
     public void serviceModelTest(){
        Integer id =1;
        Double price= 50.0;      
        String name = "Vinacho";
        Service service=new Service(id,price,name);
        assertEquals(id, service.getId());
        assertEquals(price, service.getPrice(),0.001);
        assertEquals(name, service.getName());
     }
     @Test
     public void serviceModelTest2(){
        Integer id =1;
        Double price= 50.0;      
        String name = "Piscola";
        Set<Bill> bills =new HashSet<>();
        Service service=new Service();
        service.setId(id);
        service.setPrice(price);
        service.setName(name);
        service.setBills(bills);
        assertEquals(id, service.getId());
        assertEquals(price, service.getPrice(),0.001);
        assertEquals(name, service.getName());
        assertEquals(bills, service.getBills());
     }

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