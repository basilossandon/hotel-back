package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.dto.RoomTypeDTO;
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

    @GetMapping(value = "")
    public @ResponseBody Iterable<RoomType> getAll(){
        return roomTypeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<RoomType> getRoomTypeById(@PathVariable Integer id){
        return roomTypeRepository.findById(id);
    }


    @PostMapping(value = "/add")
    @ResponseBody
    public List<RoomType> createRoomType(@RequestBody RoomTypeDTO roomType){
        RoomType roomTypeToSave = new RoomType();
        roomTypeToSave.getName(roomType.getName());
        roomTypeToSave.setPrice(roomType.getPrice());
                roomTypeRepository.save(roomTypeToSave);
        return roomTypeRepository.findAll();
    }



}
