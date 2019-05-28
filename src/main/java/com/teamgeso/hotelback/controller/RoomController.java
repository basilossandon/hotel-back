package com.teamgeso.hotelback.controller;
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
public class RoomController {
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
}
