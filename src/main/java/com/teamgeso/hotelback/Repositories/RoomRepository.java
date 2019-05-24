package com.teamgeso.hotelback.Repositories;
import com.teamgeso.hotelback.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomById(Integer id);
}

