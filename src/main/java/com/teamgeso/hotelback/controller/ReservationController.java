package com.teamgeso.hotelback.controller;
import com.teamgeso.hotelback.dao.DaoReservation;
import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/reservations")
@CrossOrigin(origins = "*")

public class ReservationController implements DaoReservation {

    @Autowired
    private ReservationRepository reservationRepository;

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
    Optional<Reservation> createReservation(@RequestBody ReservationDTO reservation){
        //Here you must to add a try catch, if the reservation given on the argument has an error.
        Reservation reservationToSave = new Reservation();
        reservationToSave.setStart(reservation.getStart());
        reservationToSave.setEnd(reservation.getEnd());
        reservationToSave.setFinalPrice(reservation.getFinalPrice());
        reservationToSave.setDocumentNumber(reservation.getDocumentNumber());
        reservationToSave.setCheckInName(reservation.getCheckInName());
        reservationToSave.setCode(reservation.getCode());
        reservationToSave.setRoomId(reservation.getRoomId());
        reservationRepository.save(reservationToSave);
        return reservationRepository.findById(reservationToSave.getId());
    }

    @PostMapping(value = "/{id}")
    public @ResponseBody
    Optional<Reservation> updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservation){
        Reservation updatedReservation = new Reservation();
        updatedReservation.setId(id);
        updatedReservation.setStart(reservation.getStart());
        updatedReservation.setEnd(reservation.getEnd());
        updatedReservation.setFinalPrice(reservation.getFinalPrice());
        updatedReservation.setDocumentNumber(reservation.getDocumentNumber());
        updatedReservation.setCheckInName(reservation.getCheckInName());
        updatedReservation.setCode(reservation.getCode());
        updatedReservation.setRoomId(reservation.getRoomId());
        reservationRepository.save(updatedReservation);
        return reservationRepository.findById(updatedReservation.getId());

    }

    @PostMapping(value = "/{id}/delete")
    public  @ResponseBody
    Iterable<Reservation> deleteReservation(@PathVariable Integer id){
        reservationRepository.deleteById(id);
        return reservationRepository.findAll();

    }

}