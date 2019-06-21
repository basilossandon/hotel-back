package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.model.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface DaoReservation {


    Iterable<Reservation> getAll();

    Optional<Reservation> getReservationById(Integer id);

    ResponseEntity createReservation(ReservationDTO reservation);
    ResponseEntity updateReservation(Integer id, ReservationDTO reservation);
    ResponseEntity deleteReservation(Integer id);
}
