package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.dao.DaoRoomType;
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


public class RoomTypeController implements DaoRoomType {

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


    @PostMapping(value = "")
    @ResponseBody
    public Optional<RoomType> createRoomType(@RequestBody RoomTypeDTO roomType){
        RoomType roomTypeToSave = new RoomType();
        roomTypeToSave.setName(roomType.getName());
        roomTypeToSave.setPrice(roomType.getPrice());
        roomTypeRepository.save(roomTypeToSave);
        return roomTypeRepository.findById(roomTypeToSave.getId());
    }

    @PostMapping (value = "/{id}")
    public @ResponseBody
    Optional<RoomType> updateRoomType(@PathVariable Integer id, @RequestBody RoomTypeDTO roomType){
        RoomType updatedRoomType = new RoomType();
        updatedRoomType.setName(roomType.getName());
        updatedRoomType.setPrice(roomType.getPrice());
        updatedRoomType.setId(id);
        roomTypeRepository.save(updatedRoomType);
        return roomTypeRepository.findById(updatedRoomType.getId());
    }

    @PostMapping (value = "/{id}/delete")
    public @ResponseBody
    List<RoomType> deleteRoomType(@PathVariable Integer id){
        roomTypeRepository.deleteById(id);
        return roomTypeRepository.findAll();
    }





}
