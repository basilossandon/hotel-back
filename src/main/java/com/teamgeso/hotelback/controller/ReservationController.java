package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.dao.DaoReservation;
import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.model.Service;
import com.teamgeso.hotelback.model.Bill;
import com.teamgeso.hotelback.model.Room;
import com.teamgeso.hotelback.dto.ReservationDTO;
import com.teamgeso.hotelback.dto.ServiceListDTO;
import com.teamgeso.hotelback.repository.ReservationRepository;
import com.teamgeso.hotelback.repository.ServiceRepository;
import com.teamgeso.hotelback.repository.BillRepository;
import com.teamgeso.hotelback.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/reservations")
@CrossOrigin(origins = "*")

public class ReservationController implements DaoReservation {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ServiceRepository serviceRepository;

   private boolean isValid(String email) {
      return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
   }

    @GetMapping(value = "")
    public @ResponseBody Iterable<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<Reservation> getReservationById(@PathVariable Integer id){
        return reservationRepository.findById(id);
    }

    @PostMapping(value = "")
    public @ResponseBody
    ResponseEntity createReservation(@RequestBody ReservationDTO reservation){
        List<Reservation> allReservation = reservationRepository.findAll();
        Reservation createdReservation = new Reservation();

        Room requestedRoom = roomRepository.findRoomById(reservation.getRoomId());

        if (requestedRoom == null)
            return new ResponseEntity<>("La habitación ingresada no existe.", HttpStatus.BAD_REQUEST);

        createdReservation.setStart(reservation.getStart());
        createdReservation.setEnd(reservation.getEnd());
        createdReservation.setDocumentNumber(reservation.getDocumentNumber());
        createdReservation.setCheckInName(reservation.getCheckInName());
        createdReservation.setCode(reservation.getCode());
        createdReservation.setEmail(reservation.getEmail());
        createdReservation.setRoomId(reservation.getRoomId());

        if (createdReservation.getStart() != null &&
            createdReservation.getEnd() != null &&
            createdReservation.getDocumentNumber() != null &&
            createdReservation.getCheckInName() != null &&
            createdReservation.getCode() != null && 
            createdReservation.getEmail() != null &&
            createdReservation.getRoomId() != null ){

            if (! this.isValid(createdReservation.getEmail()) ){
                return new ResponseEntity<>("El correo ingresado no es válido.", HttpStatus.BAD_REQUEST);
            }

            for (Reservation roomReservation : allReservation){
                if (roomReservation.getRoomId().equals(requestedRoom.getId())){
                    if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                        return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                    else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
                        return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
                }
            }

            if (createdReservation.getStart().isAfter(createdReservation.getEnd()))
                return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(reservationRepository.save(createdReservation),HttpStatus.CREATED);
        }   

        return new ResponseEntity<>("La reserva a crear no puede contener valores nulos.", HttpStatus.BAD_REQUEST);

    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservation){
        List<Reservation> allReservation = reservationRepository.findAll();
        Reservation reservationToUpdate = reservationRepository.findReservationById(id);
        Room requestedRoom = roomRepository.findRoomById(reservation.getRoomId());

        if (reservationToUpdate == null)
            return new ResponseEntity<>("La reserva no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        reservationToUpdate.setStart(reservation.getStart());
        reservationToUpdate.setEnd(reservation.getEnd());
        reservationToUpdate.setDocumentNumber(reservation.getDocumentNumber());
        reservationToUpdate.setCheckInName(reservation.getCheckInName());
        reservationToUpdate.setCode(reservation.getCode());
        reservationToUpdate.setEmail(reservation.getEmail());
        reservationToUpdate.setRoomId(reservation.getRoomId());

        if (reservationToUpdate.getStart() != null &&
            reservationToUpdate.getEnd() != null &&
            reservationToUpdate.getDocumentNumber() != null &&
            reservationToUpdate.getCheckInName() != null &&
            reservationToUpdate.getCode() != null &&
            reservationToUpdate.getEmail() != null && 
            reservationToUpdate.getRoomId() != null){

                if (! this.isValid(reservationToUpdate.getEmail()) )
                    return new ResponseEntity<>("El correo ingresado no es válido.", HttpStatus.BAD_REQUEST);

                for (Reservation roomReservation : allReservation){
                    if (roomReservation.getRoomId().equals(requestedRoom.getId())){
                        if (reservation.getEnd().isAfter(roomReservation.getStart()) && reservation.getEnd().isBefore(roomReservation.getEnd()))
                            return new ResponseEntity<>("El fin de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);

                        else if (reservation.getStart().isAfter(roomReservation.getStart()) && reservation.getStart().isBefore(roomReservation.getEnd()))
                            return new ResponseEntity<>("El inicio de la reserva se encuentra entre una reserva ya solicitada.", HttpStatus.BAD_REQUEST);
                    }
                }

                if (reservationToUpdate.getStart().isAfter(reservationToUpdate.getEnd()))
                    return new ResponseEntity<>("La fecha de inicio no puede ser posterior a la fecha de termino.", HttpStatus.BAD_REQUEST);
                
            return new ResponseEntity<>(reservationRepository.save(reservationToUpdate),HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Un valor no puede ser modificado por un valor nulo.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}/delete")
    public  @ResponseBody
    ResponseEntity deleteReservation(@PathVariable Integer id){
        Reservation reservationToDelete = reservationRepository.findReservationById(id);
        
        if (reservationToDelete != null){
            reservationRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("La reserva a borrar no existe.", HttpStatus.BAD_REQUEST);

    }

    @PostMapping(value = "/code/{code}")
    public @ResponseBody
    ResponseEntity findByCode(@PathVariable String code){
        List<Reservation> reservations = reservationRepository.findByCode(code);

        if (reservations.isEmpty())
            return new ResponseEntity<>("No se han encontrado reservas con ese código", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    // @PostMapping(value = "/{id}/addService/{serviceId}")
    // public @ResponseBody
    // ResponseEntity addServiceToReservation(@PathVariable Integer id, @PathVariable Integer serviceId){
    //     Reservation reservation = reservationRepository.findReservationById(id);
    //     Service service = serviceRepository.findServiceById(serviceId);

        // if (service != null && reservation != null){
        //     Bill bill = billRepository.findBillById(reservation.getBillId());
        //     bill.getServices().add(service);
        //     service.getBills().add(bill);
        //     bill.
        //     billRepository.save(bill);
        //     return new ResponseEntity<>("Se ha añadido el servicio correctamente.", HttpStatus.OK);
        // }

    //     return new ResponseEntity<>("El servicio o el registro no se han encontrado.", HttpStatus.BAD_REQUEST);
    // }

    @PostMapping(value = "/{id}/addService")
    public @ResponseBody
    ResponseEntity addServiceToReservation(@PathVariable Integer id, @RequestBody ServiceListDTO serviceList){
        Reservation reservation = reservationRepository.findReservationById(id);
        String serviceString = serviceList.getServiceString();
        String[] servicesSplitted = serviceString.split(";");

        for (String s : servicesSplitted)
            if (serviceRepository.findServiceById(Integer.parseInt(s)) == null)
                return new ResponseEntity<>("El servicio " + s + " no se ha encontrado", HttpStatus.BAD_REQUEST);
        
        if (reservation != null){
            Bill bill = billRepository.findBillById(reservation.getBillId());
            // bill.getServices().add(service);
            // service.getBills().add(bill);
            bill.setServiceString(serviceString);
            billRepository.save(bill);
            return new ResponseEntity<>("Se ha añadido el servicio correctamente.", HttpStatus.OK);
        }

        return new ResponseEntity<>("La reserva " + id + " no se ha encontrado", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/getBill")
    public @ResponseBody
    ResponseEntity getBillFromReservation(@PathVariable Integer id){
        return (reservationRepository.findReservationById(id) != null) ? ((reservationRepository.findReservationById(id).getBillId() != null) ? new ResponseEntity<>(billRepository.findBillById(reservationRepository.findReservationById(id).getBillId()), HttpStatus.OK) : new ResponseEntity<>("No hay registro asociado a la reserva.", HttpStatus.OK)) : new ResponseEntity<>("La reserva no se a encontrado", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "{code}/getTotal")
    public @ResponseBody
    ResponseEntity getTotal(@PathVariable String code){
        List<Reservation> reservations = reservationRepository.findByCode(code);

        if (reservations.isEmpty())
            return new ResponseEntity<>("No se han encontrado reservas con ese código", HttpStatus.BAD_REQUEST);

        List<HashMap<String, Object>> result = new ArrayList<>();
        
        for (Reservation reservation : reservations){
            Room room = roomRepository.findRoomById(reservation.getRoomId());
            HashMap<String, Object> map = new HashMap<>();
            HashMap<String, Object> mapToCount = new HashMap<>();
            Double total = 0.0;
            // Set<Service> services = billRepository.findBillById(reservation.getBillId()).getServices();
            String serviceString = billRepository.findBillById(reservation.getBillId()).getServiceString();

            if (serviceString != null){
                String[] servicesSplitted = serviceString.split(";");
                List<Service> servicesList = new ArrayList<>();

                for (String s : servicesSplitted)
                    servicesList.add(serviceRepository.findServiceById(Integer.parseInt(s)));

                for (Service s : servicesList){
                    Integer amount = (Integer)mapToCount.get(s.getName());
                    mapToCount.put(s.getName(), (amount == null) ? 1 : amount + 1);
                }

                for (Service service : servicesList){
                    Integer amount = (Integer)mapToCount.get(service.getName());
                    map.put((amount == null) ? service.getName() : service.getName() + "(x" + amount + ")", (amount == null) ? service.getPrice() : service.getPrice() * amount); 
                    Double plus = (amount == null) ? service.getPrice() : service.getPrice() * amount;
                    total += plus;
                }

                map.put("serviceString", serviceString);
            } else {
                map.put("serviceString", "");
            }

            map.put("room", reservation.getRoomId());
            map.put("roomValue", room.getPrice());
            total += room.getPrice();



            map.put("total", total);
            result.add(map);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}