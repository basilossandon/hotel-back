package com.teamgeso.hotelback.controllers;
import com.teamgeso.hotelback.models.Room;
import com.teamgeso.hotelback.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class roomController {
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
