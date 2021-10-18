package com.tn.totnghiep.repository.customer;

import com.tn.totnghiep.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Integer countAllByEmail(String email);

    Optional<CustomerEntity> findByEmail(String email);
}
