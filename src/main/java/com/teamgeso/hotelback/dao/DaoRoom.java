package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.model.Room;


import java.util.List;
import java.util.Optional;

public interface DaoRoom {
    List<Room> getAllRooms();
    Room getRoomById(Integer id);
    Optional<Room> createRoom(RoomDTO room);
    Optional<Room> updateRoom(Integer id,RoomDTO room);
    Iterable<Room> deleteRoom(Integer id);
}
