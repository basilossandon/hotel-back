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
import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
@CrossOrigin(origins = "*")

public class ReservationController implements DaoReservation {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

   private boolean isValid(String email) {
      return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
   }

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
        List<Reservation> allReservation = reservationRepository.findAll();
        Reservation createdReservation = new Reservation();

        Room requestedRoom = roomRepository.findRoomById(reservation.getRoomId());

        System.out.println(requestedRoom.getId());
        System.out.println(requestedRoom.getPrice());


        createdReservation.setStart(reservation.getStart());
        createdReservation.setEnd(reservation.getEnd());
        createdReservation.setDocumentNumber(reservation.getDocumentNumber());
        createdReservation.setCheckInName(reservation.getCheckInName());
        createdReservation.setCode(reservation.getCode());
        createdReservation.setEmail(reservation.getEmail());
        createdReservation.setRoomId(reservation.getRoomId());

        if (createdReservation.getStart() != null &&
            createdReservation.getEnd() != null &&
            createdReservation.getDocumentNumber() != null &&
            createdReservation.getCheckInName() != null &&
            createdReservation.getCode() != null && 
            createdReservation.getEmail() != null &&
            createdReservation.getRoomId() != null ){

            if (! this.isValid(createdReservation.getEmail()) ){
                return new ResponseEntity<>("El correo ingresado no es válido.", HttpStatus.BAD_REQUEST);
            }

            for (Reservation roomReservation : allReservation){
                if (roomReservation.getRoomId() == requestedRoom.getId()){
                    if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                        return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                    // I think that this else if is not necessary, but im not totally sure yet, so I will comment it.
                    // else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                        // return new ResponseEntity<>("La reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                    else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
                        return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
                }
            }

            if (createdReservation.getStart().isAfter(createdReservation.getEnd()))
                return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(reservationRepository.save(createdReservation),HttpStatus.CREATED);
        }
            

        return new ResponseEntity<>("La reserva a crear no puede contener valores nulos.", HttpStatus.BAD_REQUEST);

    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservation){
        List<Reservation> allReservation = reservationRepository.findAll();
        Reservation reservationToUpdate = reservationRepository.findReservationById(id);
        Room requestedRoom = roomRepository.findRoomById(reservation.getRoomId());

        if (reservationToUpdate == null)
            return new ResponseEntity<>("La reserva no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        reservationToUpdate.setStart(reservation.getStart());
        reservationToUpdate.setEnd(reservation.getEnd());
        reservationToUpdate.setDocumentNumber(reservation.getDocumentNumber());
        reservationToUpdate.setCheckInName(reservation.getCheckInName());
        reservationToUpdate.setCode(reservation.getCode());
        reservationToUpdate.setEmail(reservation.getEmail());
        reservationToUpdate.setRoomId(reservation.getRoomId());

        if (reservationToUpdate.getStart() != null &&
            reservationToUpdate.getEnd() != null &&
            reservationToUpdate.getDocumentNumber() != null &&
            reservationToUpdate.getCheckInName() != null &&
            reservationToUpdate.getCode() != null &&
            reservationToUpdate.getEmail() != null && 
            reservationToUpdate.getRoomId() != null){

                if (! this.isValid(reservationToUpdate.getEmail()) )
                    return new ResponseEntity<>("El correo ingresado no es válido.", HttpStatus.BAD_REQUEST);

                for (Reservation roomReservation : allReservation){
                    if (roomReservation.getRoomId() == requestedRoom.getId()){
                        if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                            return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                        // I think that this else if is not necessary, but im not totally sure yet, so I will comment it.
                        // else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                            // return new ResponseEntity<>("La reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                        else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
                            return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
                    }
                }

                if (reservationToUpdate.getStart().isAfter(reservationToUpdate.getEnd()))
                    return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);
                
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

    // @PostMapping("/{id}/rooms/{idRoom}")
    // @ResponseBody
    // public ResponseEntity linkRoomToReservation (@PathVariable("id") Integer id, @PathVariable("idRoom") Integer idRoom) {

    //     Reservation reservation = reservationRepository.findReservationById(id);
    //     Room room = roomRepository.findRoomById(idRoom);

    //     if (reservation != null && room != null) {
    //         for (Reservation roomReservation : room.getReservations()){
    //             if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
    //                 return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

    //             // I think that this else if is not necessary, but im not totally sure yet, so I will comment it.
    //             // else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
    //                 // return new ResponseEntity<>("La reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

    //             else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
    //                 return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
    //         }

    //         reservation.getRooms().add(room);
    //         room.getReservations().add(reservation);
    //         roomRepository.save(room);

    //         return new ResponseEntity<>("La reserva se ha asignado correctamente a la habitación", HttpStatus.OK);
    //     }

    //     return new ResponseEntity<>("La habitación y/o la reserva no se han encontrado.", HttpStatus.NOT_ACCEPTABLE);
    // }

}