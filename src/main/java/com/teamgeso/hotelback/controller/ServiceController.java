package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.model.Service;
import com.teamgeso.hotelback.dao.DaoService;
import com.teamgeso.hotelback.dto.ServiceDTO;
import com.teamgeso.hotelback.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/services")
@CrossOrigin(origins = "*")
public class ServiceController implements DaoService {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("")
    @ResponseBody
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Service getServiceById(@PathVariable Integer id) {
        return serviceRepository.findServiceById(id);
    }

    @PostMapping(value = "")
    public @ResponseBody
    ResponseEntity createService(@RequestBody ServiceDTO service){
        Service createdService = new Service();
        createdService.setPrice(service.getPrice());
        createdService.setName(service.getName());

        if (createdService.getPrice() != null && createdService.getName() != null){
            if (createdService.getPrice() <= 0)
                return new ResponseEntity<>("El valor del servicio es menor o igual a 0.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(serviceRepository.save(createdService),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("El servicio a crear no puede contener campos nulos.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateService(@PathVariable Integer id, @RequestBody ServiceDTO service){
        Service serviceToUpdate = serviceRepository.findServiceById(id);
        if (serviceToUpdate == null)
            return new ResponseEntity<>("El servicio a editar no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        serviceToUpdate.setPrice(service.getPrice());
        serviceToUpdate.setName(service.getName());

        if (serviceToUpdate.getPrice() != null && serviceToUpdate.getName() != null){
            if (serviceToUpdate.getPrice() <= 0)
                return new ResponseEntity<>("El valor del servicio es menor o igual a 0.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(serviceRepository.save(serviceToUpdate),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Un campo no puede ser modificado por un valor nulo.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}/delete")
    public @ResponseBody
    ResponseEntity deleteService(@PathVariable Integer id){
        Service serviceToDelete = serviceRepository.findServiceById(id);
        
        if (serviceToDelete != null){
            serviceRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("La habitación a borrar no existe.", HttpStatus.BAD_REQUEST);
    }


    //THIS SHOULD GO ON BILL CONTROLLER
    // @PostMapping("/{id}/rooms/{idRoom}")
    // @ResponseBody
    // public ResponseEntity linkBillToReservation (@PathVariable("id") Integer id, @PathVariable("idBill") Integer idRoom) {

    //     Reservation reservation = reservationRepository.findReservationById(id);
    //     Room room = roomRepository.findRoomById(idRoom);

    //     if (reservation != null && room != null) {
    //         for (Reservation roomReservation : room.getReservations()){
    //             if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
    //                 return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

    //             // I think that this else if is not necessary, but im not totally sure yet, so I will comment it.
    //             // else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
    //                 // return new ResponseEntity<>("La reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

    //             else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
    //                 return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
    //         }

    //         reservation.getRooms().add(room);
    //         room.getReservations().add(reservation);
    //         roomRepository.save(room);

    //         return new ResponseEntity<>("La reserva se ha asignado correctamente a la habitación", HttpStatus.OK);
    //     }

    //     return new ResponseEntity<>("La habitación y/o la reserva no se han encontrado.", HttpStatus.NOT_ACCEPTABLE);
    // }
}
