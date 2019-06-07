package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.RoomTypeDTO;
import com.teamgeso.hotelback.model.RoomType;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface DaoRoomType {
    Iterable<RoomType> getAll();
    Optional<RoomType> getRoomTypeById(Integer id);
    ResponseEntity createRoomType(RoomTypeDTO roomType);
    ResponseEntity updateRoomType(Integer id, RoomTypeDTO roomType);
    ResponseEntity deleteRoomType(Integer id);
}
