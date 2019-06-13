package com.teamgeso.hotelback.repository;
import com.teamgeso.hotelback.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findMemberById(Integer id);
}

