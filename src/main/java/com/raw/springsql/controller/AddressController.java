package com.raw.springsql.controller;

import com.raw.springsql.response.AddressResponse;
import com.raw.springsql.response.EmployeeResponse;
import com.raw.springsql.service.AddressService;
import com.raw.springsql.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private static final Logger logger =LoggerFactory.getLogger(AddressController.class);
//    @Autowired
    private final AddressService addressService;
//
//    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    public AddressController(AddressService addressService, EmployeeService employeeService){
        this.employeeService = employeeService;
        this.addressService = addressService;
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestParam String name, @RequestParam String email, @RequestParam int age, @RequestParam int id){
        logger.info("masuk insert "+ name + " "+ email + " " + age);

        employeeService.InsertEmployee(id, name, email, age);
    }
}
