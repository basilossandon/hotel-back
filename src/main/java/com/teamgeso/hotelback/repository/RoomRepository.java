package com.teamgeso.hotelback.repository;
import com.teamgeso.hotelback.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomById(Integer id);
}

