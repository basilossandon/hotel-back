package com.teamgeso.hotelback.controller;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@CrossOrigin(origins = "*")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Room getRoomById(@PathVariable Integer id) {
        return roomRepository.findRoomById(id);
    }
}
