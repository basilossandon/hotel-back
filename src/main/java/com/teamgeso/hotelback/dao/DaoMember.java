package com.teamgeso.hotelback.dao;

import com.teamgeso.hotelback.dto.MemberDTO;
import com.teamgeso.hotelback.model.Member;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DaoMember {
    List<Member> getAllMembers();
    Member getMemberById(Integer id);
    ResponseEntity createMember(MemberDTO member);
    ResponseEntity updateMember(Integer id,MemberDTO member);
    ResponseEntity deleteMember(Integer id);
}
