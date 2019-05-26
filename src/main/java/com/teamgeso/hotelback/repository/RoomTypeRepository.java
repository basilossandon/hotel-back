package com.teamgeso.hotelback.repository;
import com.teamgeso.hotelback.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    RoomType findRoomTypeById(Integer id);
}

