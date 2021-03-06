package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.model.Bill;
import com.teamgeso.hotelback.repository.BillRepository;
import com.teamgeso.hotelback.dao.DaoBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/bills")
@CrossOrigin(origins = "*")
public class BillController implements DaoBill {
    @Autowired
    private BillRepository billRepository;

    @GetMapping("")
    @ResponseBody
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Bill getBillById(@PathVariable Integer id) {
        return billRepository.findBillById(id);
    }
}