package com.teamgeso.hotelback.controller;
import com.teamgeso.hotelback.dao.DaoRoom;
import com.teamgeso.hotelback.dto.RoomDTO;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    ResponseEntity createRoom(@RequestBody RoomDTO room){
        Room createdRoom = new Room();
        createdRoom.setPrice(room.getPrice());
        createdRoom.setRoomTypeId(room.getRoomTypeId());

        if (createdRoom.getPrice() != null && createdRoom.getRoomTypeId() != null){
            if (createdRoom.getPrice() < 0)
                return new ResponseEntity<>("El valor de la habitación es menor a 0.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(roomRepository.save(createdRoom),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("La habitación a crear no puede contener valores nulos.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateRoom(@PathVariable Integer id, @RequestBody RoomDTO room){
        Room roomToUpdate = roomRepository.findRoomById(id);
        if (roomToUpdate == null)
            return new ResponseEntity<>("La habitación a editar no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        roomToUpdate.setPrice(room.getPrice());
        roomToUpdate.setRoomTypeId(room.getRoomTypeId());

        if (roomToUpdate.getPrice() != null && roomToUpdate.getRoomTypeId() != null){
            if (roomToUpdate.getPrice() < 0)
                return new ResponseEntity<>("El valor de la habitación es menor a 0.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(roomRepository.save(roomToUpdate),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Un valor no puede ser modificado por un valor nulo.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}/delete")
    public @ResponseBody
    ResponseEntity deleteRoom(@PathVariable Integer id){
        Room roomToDelete = roomRepository.findRoomById(id);
        
        if (roomToDelete != null){
            roomRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("La habitación a borrar no existe.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{id}/services/{idService}")
    @ResponseBody
    public HttpStatus linkServiceToRoom (@PathVariable("id") Integer id, @PathVariable("idService") Integer idService) {

        Reservation service = reservationRepository.findServiceById(id);
        Room room = roomRepository.findRoomById(idRoom);

        if (service != null && room != null) {
            room.getReservations().add(service);
            service.getRooms().add(room);
            roomRepository.save(room);
            return new ResponseEntity<>("Se ha asignado el servicio a la habitación correctamente.", HttpStatus.OK);
        }
        
        return new ResponseEntity<>("El servicio o la habitación no se han encontado. No se pudo reservar.", HttpStatus.NOT_ACCEPTABLE);
    }
}
