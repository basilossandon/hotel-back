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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody Iterable<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Reservation> getReservationById(@PathVariable Integer id){
        return reservationRepository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    Optional<Reservation> createReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
        return reservationRepository.findById(reservation.getId());
    }

}
