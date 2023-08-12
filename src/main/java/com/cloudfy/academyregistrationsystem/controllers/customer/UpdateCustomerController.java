package com.cloudfy.academyregistrationsystem.controllers.customer;

import com.cloudfy.academyregistrationsystem.models.dto.CustomerDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.services.customers.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "/customer/update")
public class UpdateCustomerController {

    @Autowired
    private UpdateCustomerService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@RequestBody CustomerDTO data, @PathVariable Long id){
        Customer customer = service.fromDTO(data);
        customer.setId(id);
        service.update(customer);
        return ResponseEntity.noContent().build();
    }
}