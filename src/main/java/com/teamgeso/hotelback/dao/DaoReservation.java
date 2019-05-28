package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.model.Reservation;

import java.util.Optional;

public interface DaoReservation {


    Iterable<Reservation> getAll();

    Optional<Reservation> getReservationById(Integer id);

    Optional<Reservation> createReservation(ReservationDTO reservation);
}
