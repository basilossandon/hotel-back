package com.teamgeso.hotelback;

import org.junit.Test;
import static org.junit.Assert.*;

import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.model.Service;
import com.teamgeso.hotelback.model.Bill;
import com.teamgeso.hotelback.model.Member;
import com.teamgeso.hotelback.dto.MemberDTO;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.dto.ServiceDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
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
         Integer roomId=1;
         Integer billId=1;
         String documentNumber = "1453241";
         String checkInName = "Gabriel";
         String code = "AX3400";
         String email="gabriel@usahc.cl";
         List<Member> members = new ArrayList<>();
         Reservation reservation = new Reservation();

         reservation.setId(id);
         reservation.setStart(now);
         reservation.setEnd(tomorrow);
         
         reservation.setDocumentNumber(documentNumber);
         reservation.setCheckInName(checkInName);
         reservation.setCode(code);
         reservation.setEmail(email);
         reservation.setBillId(billId);
         reservation.setRoomId(roomId);
         reservation.setMembers(members);
         //setEmail

         assertEquals(reservation.getId(), id);
         assertEquals(reservation.getStart(), now);
         assertEquals(reservation.getEnd(), tomorrow);
         assertEquals(billId, reservation.getBillId());
         assertEquals(roomId, reservation.getRoomId());
         assertEquals(members, reservation.getMembers());
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
     @Test

     public void memberModelTest(){
        Integer id =1;
        String name="Claudio";
        String documentNumber="19185415";
        Integer age=23;
        String country="Japon";
        Reservation reservation= new Reservation();
        Member member = new Member(id,name,documentNumber,age,country,reservation);
        assertEquals(id, member.getId());
        assertEquals(name, member.getName());
        assertEquals(documentNumber, member.getDocumentNumber());
        assertEquals(age, member.getAge());
        assertEquals(country, member.getCountry());
        assertEquals(reservation,member.getReservation());
     }
     @Test

     public void memberModelTest2(){
        Integer id =1;
        String name="Claudio";
        String documentNumber="19185415";
        Integer age=23;
        String country="Japon";
        
        Reservation reservation= new Reservation();
        Member member = new Member();
        member.setId(id);
        member.setAge(age);
        member.setCountry(country);
        member.setName(name);
        member.setDocumentNumber(documentNumber);
        member.setReservation(reservation);
        assertEquals(id, member.getId());
        assertEquals(name, member.getName());
        assertEquals(documentNumber, member.getDocumentNumber());
        assertEquals(age, member.getAge());
        assertEquals(country, member.getCountry());
        assertEquals(reservation,member.getReservation());
     }
     @Test
     public void reservationDTOModelTest(){
           	
        String documentNumber = "1453241";
        String checkInName = "Gabriel";
        String code = "AX3400";
        String email = "gabriel@usach.cl";
        Double finalPrice=20000.0;
        Integer roomId=1;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
         
         ReservationDTO reservation = new ReservationDTO();

         reservation.setStart(now);
         reservation.setEnd(tomorrow);
         reservation.setFinalPrice(finalPrice);
         reservation.setDocumentNumber(documentNumber);
         reservation.setCheckInName(checkInName);
         reservation.setCode(code);
         reservation.setEmail(email);
         reservation.setRoomId(roomId);
         assertEquals(reservation.getStart(), now);
         assertEquals(reservation.getEnd(), tomorrow);
         assertEquals(finalPrice, reservation.getFinalPrice());
         assertEquals(documentNumber, reservation.getDocumentNumber());
         assertEquals(checkInName, reservation.getCheckInName());
         assertEquals(code, reservation.getCode());
         assertEquals(reservation.getEmail(),email);
         assertEquals(roomId, reservation.getRoomId());
     }

     @Test
     public void roomDTOModelTest(){
         Integer capacity = 2;
         Double price = 10000.0;
         String roomTypeId = "Matrimonial";

         RoomDTO room = new RoomDTO();
         room.setCapacity(capacity);
         room.setPrice(price);
         room.setType(roomTypeId);

         assertEquals(room.getCapacity(), capacity);
         assertEquals(room.getPrice(), price, 0.001);
         assertEquals(room.getType(), roomTypeId);
     }
     @Test
     public void serviceDTOModelTest(){
        Double price= 50.0;      
        String name = "Vinacho";

        ServiceDTO service = new ServiceDTO();
        
        service.setPrice(price);
        service.setName(name);

        assertEquals(service.getName(), name);
        assertEquals(service.getPrice(), price, 0.001);
        
     }
     @Test
     public void memberDTOModelTest(){
        String name="Claudio";
        String documentNumber="19185415";
        Integer age=23;
        String country="Japon";
        Reservation reservation= new Reservation();

        MemberDTO member = new MemberDTO();
        
        member.setAge(age);
        member.setCountry(country);
        member.setDocumentNumber(documentNumber);
        member.setReservationId(reservation.getId());
        member.setName(name);

        
        assertEquals(name, member.getName());
        assertEquals(documentNumber, member.getDocumentNumber());
        assertEquals(age, member.getAge());
        assertEquals(country, member.getCountry());
        assertEquals(reservation.getId(),member.getReservationId());
        
     }



}