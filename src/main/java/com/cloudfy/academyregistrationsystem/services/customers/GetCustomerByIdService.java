package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import com.cloudfy.academyregistrationsystem.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomerByIdService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(Long id){
        Optional<Customer> customer = repository.findById(id);
        return customer.orElseThrow(() -> new ObjectNotFoundException("Customer not found!"));
    }
}