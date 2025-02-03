package com.app.project.main.services.impl;

import com.app.project.main.dto.AddressDTO;
import com.app.project.main.entities.Address;
import com.app.project.main.repositories.AddressRepository;
import com.app.project.main.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    private AddressDTO convertToDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    private Address convertToEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AddressDTO> getAddressById(int id) {
        return addressRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = convertToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return convertToDTO(savedAddress);
    }

    @Override
    public Optional<AddressDTO> updateAddress(int id, AddressDTO addressDTO) {
        return addressRepository.findById(id).map(existingAddress -> {
            existingAddress.setCity(addressDTO.getCity());
            existingAddress.setPostalCode(addressDTO.getPostalCode());
            existingAddress.setState(addressDTO.getState());
            existingAddress.setCountry(addressDTO.getCountry());
            return convertToDTO(addressRepository.save(existingAddress));
        });
    }

    @Override
    public boolean deleteAddress(int id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
