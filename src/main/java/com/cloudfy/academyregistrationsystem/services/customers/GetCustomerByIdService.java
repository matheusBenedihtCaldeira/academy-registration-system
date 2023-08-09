package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerByIdService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(Long id){
        Customer customer = repository.findById(id).get();
        return customer;
    }
}