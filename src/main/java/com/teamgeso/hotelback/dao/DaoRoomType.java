package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.RoomTypeDTO;
import com.teamgeso.hotelback.model.RoomType;

import java.util.List;
import java.util.Optional;

public interface DaoRoomType {
    Iterable<RoomType> getAll();
    Optional<RoomType> getRoomTypeById(Integer id);
    Optional<RoomType> createRoomType(RoomTypeDTO roomType);
    Optional<RoomType> updateRoomType(Integer id, RoomTypeDTO roomType);
    Iterable<RoomType> deleteRoomType(Integer id);
}
