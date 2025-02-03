package com.app.project.main.controllers;

import com.app.project.main.dto.AddressDTO;
import com.app.project.main.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	// Get all addresses
	@GetMapping
	public List<AddressDTO> getAllAddresses() {
		return addressService.getAllAddresses();
	}

	// Get a single address by ID
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id) {
		return addressService.getAddressById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Create a new address
	@PostMapping
	public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
		return addressService.createAddress(addressDTO);
	}

	// Update an existing address
	@PutMapping("/{id}")
	public ResponseEntity<AddressDTO> updateAddress(@PathVariable int id, @RequestBody AddressDTO addressDTO) {
		return addressService.updateAddress(id, addressDTO).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// Delete an address by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable int id) {
		if (addressService.deleteAddress(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
