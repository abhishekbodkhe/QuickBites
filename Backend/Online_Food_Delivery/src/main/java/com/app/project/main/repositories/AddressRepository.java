package com.app.project.main.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.project.main.dto.AddressDTO;
import com.app.project.main.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
