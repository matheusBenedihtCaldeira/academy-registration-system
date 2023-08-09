package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCustomersService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> index(){
        List<Customer> list = repository.findAll();
        return list;
    }
}