package com.app.project.main.services;

import com.app.project.main.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    // Retrieve all addresses as DTOs
    List<AddressDTO> getAllAddresses();

    // Retrieve a single address by ID as DTO
    Optional<AddressDTO> getAddressById(int id);

    // Create a new address from a DTO
    AddressDTO createAddress(AddressDTO addressDTO);

    // Update an existing address by ID using a DTO
    Optional<AddressDTO> updateAddress(int id, AddressDTO addressDTO);

    // Delete an address by ID
    boolean deleteAddress(int id);
}
