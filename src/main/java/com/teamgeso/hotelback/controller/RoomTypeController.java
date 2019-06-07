package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.dao.DaoRoomType;
import com.teamgeso.hotelback.dto.RoomTypeDTO;
import com.teamgeso.hotelback.model.RoomType;
import com.teamgeso.hotelback.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity createRoomType(@RequestBody RoomTypeDTO roomType){
        RoomType createdRoomType = new RoomType();
        createdRoomType.setName(roomType.getName());
        createdRoomType.setPrice(roomType.getPrice());
        createdRoomType.setCapacity(roomType.getCapacity());

        if (createdRoomType.getName() != null && createdRoomType.getPrice() != null && createdRoomType.getCapacity() != null){
            if (createdRoomType.getPrice() <= 0 || createdRoomType.getCapacity() <= 0)
                return new ResponseEntity<>("El precio y/o la capacidad de la habitación son menores o iguales a 0", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(roomTypeRepository.save(createdRoomType),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("El tipo de habitación no puede contener valores nulos.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping (value = "/{id}")
    public @ResponseBody
    ResponseEntity updateRoomType(@PathVariable Integer id, @RequestBody RoomTypeDTO roomType){
        RoomType roomTypeToUpdate = roomTypeRepository.findRoomTypeById(id);
        if (roomTypeToUpdate == null)
            return new ResponseEntity<>("La habitación a editar no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        roomTypeToUpdate.setPrice(roomType.getPrice());
        roomTypeToUpdate.setName(roomType.getName());
        roomTypeToUpdate.setCapacity(roomType.getCapacity());

        if (roomTypeToUpdate.getPrice() != null && roomTypeToUpdate.getName() != null && roomTypeToUpdate.getCapacity() != null){
            if (roomTypeToUpdate.getPrice() < 0 || roomTypeToUpdate.getCapacity() <= 0)
                return new ResponseEntity<>("El precio y/o la capacidad de la habitación son menores o iguales a 0", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(roomTypeRepository.save(roomTypeToUpdate),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Un valor no puede ser modificado por un valor nulo.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping (value = "/{id}/delete")
    public @ResponseBody
    ResponseEntity deleteRoomType(@PathVariable Integer id){
        RoomType roomTypeToDelete = roomTypeRepository.findRoomTypeById(id);
        
        if (roomTypeToDelete != null){
            roomTypeRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("El tipo de habitación a borrar no existe.", HttpStatus.BAD_REQUEST);
    }





}
