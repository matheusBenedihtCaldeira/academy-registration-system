package com.cloudfy.academyregistrationsystem.controllers.customer;

import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.services.customers.IndexCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/customers")
public class IndexCustomersController {

    @Autowired
    private IndexCustomersService service;

    @GetMapping
    public ResponseEntity<List<Customer>> index() {
        List<Customer> list = service.index();
        return ResponseEntity.ok().body(list);
    }

}