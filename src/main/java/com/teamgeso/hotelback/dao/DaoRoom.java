package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.model.Room;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DaoRoom {
    List<Room> getAllRooms();
    Room getRoomById(Integer id);
    ResponseEntity createRoom(RoomDTO room);
    ResponseEntity updateRoom(Integer id,RoomDTO room);
    ResponseEntity deleteRoom(Integer id);
}
