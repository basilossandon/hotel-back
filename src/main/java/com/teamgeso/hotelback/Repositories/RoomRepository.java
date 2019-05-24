package com.teamgeso.hotelback.Repositories;
import com.teamgeso.hotelback.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomById(Integer id);
}

