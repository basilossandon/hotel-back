package com.teamgeso.hotelback.controller;
import com.teamgeso.hotelback.dao.DaoRoom;
import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/rooms")
@CrossOrigin(origins = "*")
public class RoomController implements DaoRoom {
    @Autowired
    private RoomRepository roomRepository;
    @GetMapping("")
    @ResponseBody
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Room getRoomById(@PathVariable Integer id) {
        return roomRepository.findRoomById(id);
    }

    @PostMapping(value = "")
    public @ResponseBody
    Optional<Room> createRoom(@RequestBody RoomDTO room){
        Room roomToSave = new Room();
        roomToSave.setCapacity(room.getCapacity());
        roomToSave.setPrice(room.getPrice());
        roomToSave.setRoomTypeId(room.getRoomTypeId());
        roomRepository.save(roomToSave);
        return roomRepository.findById(roomToSave.getId());
    }

    @PostMapping(value = "/{id}")
    public @ResponseBody
    Optional<Room> updateRoom(@PathVariable Integer id, @RequestBody RoomDTO room){
        Room updatedRoom = new Room();
        updatedRoom.setCapacity(room.getCapacity());
        updatedRoom.setPrice(room.getPrice());
        updatedRoom.setRoomTypeId(room.getRoomTypeId());
        updatedRoom.setId(id);
        roomRepository.save(updatedRoom);
        return roomRepository.findById(updatedRoom.getId());

    }

    @PostMapping(value = "/{id}/delete")
    public @ResponseBody
    Iterable<Room> deleteRoom(@PathVariable Integer id){
        roomRepository.deleteById(id);
        return roomRepository.findAll();
    }
}
