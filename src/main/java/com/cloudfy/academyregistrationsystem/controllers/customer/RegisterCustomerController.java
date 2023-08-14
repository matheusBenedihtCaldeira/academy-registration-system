package com.cloudfy.academyregistrationsystem.controllers.customer;

import com.cloudfy.academyregistrationsystem.models.dto.CustomerDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.services.customers.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/register/customer")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService service;

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody CustomerDTO data){
        Customer customer = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}