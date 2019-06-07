package com.teamgeso.hotelback.controller;
import com.teamgeso.hotelback.dao.DaoReservation;
import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.repository.ReservationRepository;
import com.teamgeso.hotelback.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

import java.util.Optional;

@RestController
@RequestMapping(path = "/reservations")
@CrossOrigin(origins = "*")

public class ReservationController implements DaoReservation {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value = "")
    public @ResponseBody Iterable<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<Reservation> getReservationById(@PathVariable Integer id){
        return reservationRepository.findById(id);
    }

    @PostMapping(value = "")
    public @ResponseBody
    ResponseEntity createReservation(@RequestBody ReservationDTO reservation){
        Reservation createdReservation = new Reservation();
        createdReservation.setStart(reservation.getStart());
        createdReservation.setEnd(reservation.getEnd());
        createdReservation.setFinalPrice(reservation.getFinalPrice());
        createdReservation.setDocumentNumber(reservation.getDocumentNumber());
        createdReservation.setCheckInName(reservation.getCheckInName());
        createdReservation.setCode(reservation.getCode());

        if (createdReservation.getStart() != null &&
            createdReservation.getEnd() != null &&
            createdReservation.getFinalPrice() != null &&
            createdReservation.getDocumentNumber() != null &&
            createdReservation.getCheckInName() != null &&
            createdReservation.getCode() != null ){

            if (createdReservation.getStart().isAfter(createdReservation.getEnd()))
                return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);
            if (createdReservation.getFinalPrice() < 0)
                return new ResponseEntity<>("El precio final asociado a la reserva no puede ser menor a 0", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(reservationRepository.save(createdReservation),HttpStatus.CREATED);
        }
            

        return new ResponseEntity<>("La reserva a crear no puede contener valores nulos.", HttpStatus.BAD_REQUEST);

    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservation){
        Reservation reservationToUpdate = reservationRepository.findReservationById(id);
        if (reservationToUpdate == null)
            return new ResponseEntity<>("La reserva no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        reservationToUpdate.setStart(reservation.getStart());
        reservationToUpdate.setEnd(reservation.getEnd());
        reservationToUpdate.setFinalPrice(reservation.getFinalPrice());
        reservationToUpdate.setDocumentNumber(reservation.getDocumentNumber());
        reservationToUpdate.setCheckInName(reservation.getCheckInName());
        reservationToUpdate.setCode(reservation.getCode());

        if (reservationToUpdate.getStart() != null &&
            reservationToUpdate.getEnd() != null &&
            reservationToUpdate.getFinalPrice() != null &&
            reservationToUpdate.getDocumentNumber() != null &&
            reservationToUpdate.getCheckInName() != null &&
            reservationToUpdate.getCode() != null ){
                if (reservationToUpdate.getStart().isAfter(reservationToUpdate.getEnd()))
                    return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);
                if (reservationToUpdate.getFinalPrice() < 0)
                    return new ResponseEntity<>("El precio final asociado a la reserva no puede ser menor a 0", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(reservationRepository.save(reservationToUpdate),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Un valor no puede ser modificado por un valor nulo.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}/delete")
    public  @ResponseBody
    ResponseEntity deleteReservation(@PathVariable Integer id){
        Reservation reservationToDelete = reservationRepository.findReservationById(id);
        
        if (reservationToDelete != null){
            reservationRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("La reserva a borrar no existe.", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/{id}/rooms/{idRoom}")
    @ResponseBody
    public HttpStatus linkRoomToReservation (@PathVariable("id") Integer id, @PathVariable("idRoom") Integer idRoom) {

        Reservation reservation = reservationRepository.findReservationById(id);
        Room room = roomRepository.findRoomById(idRoom);
        if (reservation != null && room != null) {
            room.getReservations().add(reservation);
            reservation.getRooms().add(room);
            roomRepository.save(room);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;
    }

}