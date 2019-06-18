package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.model.Bill;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DaoBill {
    List<Bill> getAllBills();
    Bill getBillById(Integer id);
}
