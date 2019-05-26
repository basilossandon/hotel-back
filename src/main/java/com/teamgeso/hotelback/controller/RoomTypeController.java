package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.model.RoomType;
import com.teamgeso.hotelback.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/room_types")
@CrossOrigin(origins = "*")


public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody Iterable<RoomType> getAll(){
        return roomTypeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<RoomType> getRoomTypeById(@PathVariable Integer id){
        return roomTypeRepository.findById(id);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomType> createRoomType(@RequestBody RoomType roomType){
        roomTypeRepository.save(roomType);
        return roomTypeRepository.findAll();
    }



}
