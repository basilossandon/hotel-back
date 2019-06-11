package com.teamgeso.hotelback.repository;
import com.teamgeso.hotelback.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Service findServiceById(Integer id);
}

