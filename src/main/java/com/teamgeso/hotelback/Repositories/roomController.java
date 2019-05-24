package com.teamgeso.hotelback.Repositories;
import com.teamgeso.hotelback.Models.Room;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class roomController {
    private RoomRepository roomRepository;
    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> getAllProducts() {
        return roomRepository.findAll();
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Room getRoomById(@PathVariable Integer id) {
        return roomRepository.findRoomById(id);
    }


}
