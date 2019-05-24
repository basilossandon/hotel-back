package com.teamgeso.hotelback.DAO;

import com.teamgeso.hotelback.Models.Room;

import java.util.List;

public interface RoomDAO {
    void insertRoom (Room room);
    Room getRoomById(int id);
    List<Room> getAll();
    void deleteRoom(int id);
}
