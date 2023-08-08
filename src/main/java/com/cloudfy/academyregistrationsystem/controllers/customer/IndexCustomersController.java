package com.cloudfy.academyregistrationsystem.controllers.customer;

import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/customers")
public class IndexCustomersController {

    @GetMapping
    public ResponseEntity<Customer> index(){
        Customer customer = new Customer(1L,"Matheus", "matheus@teste.com", "111.111.111-11", "111111111");
        return ResponseEntity.ok().body(customer);
    }

}