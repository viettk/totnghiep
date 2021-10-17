package com.tn.totnghiep.repository.adress;

import com.tn.totnghiep.entity.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AdressEntity, Integer> {
}
