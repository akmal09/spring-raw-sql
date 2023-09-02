package com.raw.springsql.service;

import com.raw.springsql.entity.Address;
import com.raw.springsql.repository.AddressRepo;
import com.raw.springsql.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmpoleeId(employeeId);
        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }
}
