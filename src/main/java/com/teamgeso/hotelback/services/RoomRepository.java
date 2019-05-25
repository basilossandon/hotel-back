package com.teamgeso.hotelback.services;
import com.teamgeso.hotelback.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomById(Integer id);
}

