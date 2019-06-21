package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.model.Bill;

import java.util.List;

public interface DaoBill {
    List<Bill> getAllBills();
    Bill getBillById(Integer id);
}
