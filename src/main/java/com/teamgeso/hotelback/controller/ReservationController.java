package com.teamgeso.hotelback.controller;


import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/reservations")
@CrossOrigin(origins = "*")


public class ReservationController {

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

    @PostMapping(value = "/")
    public @ResponseBody
    Optional<Reservation> createReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
        return reservationRepository.findById(reservation.getId());
    }

}
