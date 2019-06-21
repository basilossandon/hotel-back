package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.ServiceDTO;
import com.teamgeso.hotelback.model.Service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DaoService {
    List<Service> getAllServices();
    Service getServiceById(Integer id);
    ResponseEntity createService(ServiceDTO service);
    ResponseEntity updateService(Integer id, ServiceDTO service);
    ResponseEntity deleteService(Integer id);
}
