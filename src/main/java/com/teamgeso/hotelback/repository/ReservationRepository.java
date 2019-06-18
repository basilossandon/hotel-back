package com.teamgeso.hotelback.repository;
import com.teamgeso.hotelback.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationById(Integer id);
    List<Reservation> findByCode(String code);
    List<Reservation> findAll();
}

