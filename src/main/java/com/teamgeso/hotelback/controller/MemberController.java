package com.teamgeso.hotelback.controller;

import com.teamgeso.hotelback.dao.DaoMember;
import com.teamgeso.hotelback.dto.MemberDTO;
import com.teamgeso.hotelback.model.Member;
import com.teamgeso.hotelback.model.Bill;
import com.teamgeso.hotelback.model.Reservation;
import com.teamgeso.hotelback.repository.MemberRepository;
import com.teamgeso.hotelback.repository.ReservationRepository;
import com.teamgeso.hotelback.repository.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/members")
@CrossOrigin(origins = "*")
public class MemberController implements DaoMember {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BillRepository billRepository;

    @GetMapping("")
    @ResponseBody
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Member getMemberById(@PathVariable Integer id) {
        return memberRepository.findMemberById(id);
    }

    @PostMapping(value = "")
    public @ResponseBody
    ResponseEntity createMember(@RequestBody MemberDTO member){
        Member createdMember = new Member();

        createdMember.setName(member.getName());
        createdMember.setDocumentNumber(member.getDocumentNumber());
        createdMember.setAge(member.getAge());
        createdMember.setCode(member.getCode());
        createdMember.setCountry(member.getCountry());

        if (createdMember.getName() != null &&
            createdMember.getDocumentNumber() != null &&
            createdMember.getAge() != null &&
            createdMember.getCode() != null &&
            createdMember.getCountry() != null &&
            member.getReservationId() != null){

            Reservation reservation = reservationRepository.findReservationById(member.getReservationId());

            if (reservation == null)
                return new ResponseEntity<>("El miembro a crear se está asignando a una reserva no encontrada.",HttpStatus.BAD_REQUEST);

            if (createdMember.getAge() < 0)
                return new ResponseEntity<>("La edad ingresada no es válida.",HttpStatus.BAD_REQUEST);

            Bill bill = new Bill();
            bill.setRoomId(reservation.getRoomId());
            billRepository.save(bill);

            createdMember.setReservation(reservation);

            reservation.setBillId(bill.getId());
            reservation.getMembers().add(createdMember);
            reservationRepository.save(reservation);
            return new ResponseEntity<>("El miembro se ha añadido correctamente.",HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>("El miembro a crear no puede contener valores nulos.", HttpStatus.BAD_REQUEST);
    }



    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity updateMember(@PathVariable Integer id, @RequestBody MemberDTO member){
        Member memberToUpdate = memberRepository.findMemberById(id);
        if (memberToUpdate == null)
            return new ResponseEntity<>("La habitación a editar no se ha podido encontrar.", HttpStatus.BAD_REQUEST);

        memberToUpdate.setName(member.getName());

        if (memberToUpdate.getName() != null)
            return new ResponseEntity<>(memberRepository.save(memberToUpdate),HttpStatus.CREATED);

        return new ResponseEntity<>("El miembro no puede ser modificado con valores nulos.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}/delete")
    public @ResponseBody
    ResponseEntity deleteMember(@PathVariable Integer id){
        Member memberToDelete = memberRepository.findMemberById(id);
        
        if (memberToDelete != null){
            memberRepository.deleteById(id);
            return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
        }

        return new ResponseEntity<>("La habitación a borrar no existe.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{documentNumber}/service/{idService}")
    @ResponseBody
    public ResponseEntity requestServiceToRoom (@PathVariable("") Integer id, @PathVariable("idReservation") Integer idReservation) {

        Reservation reservation = reservationRepository.findReservationById(idReservation);
        Member member = memberRepository.findMemberById(id);

        if (reservation != null && member != null) {
            member.setReservation(reservation);
            reservation.getMembers().add(member);
            memberRepository.save(member);
            return new ResponseEntity<>("Se ha asignado el servicio a la habitación correctamente.", HttpStatus.OK);
        }
        
        return new ResponseEntity<>("El servicio o la habitación no se han encontado. No se pudo reservar.", HttpStatus.NOT_ACCEPTABLE);
    }
}
