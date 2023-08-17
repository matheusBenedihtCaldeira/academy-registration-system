package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.models.dto.CustomerDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer register(CustomerDTO data){
        Customer customer = fromDTO(data);
        return repository.save(customer);
    }

    public Customer fromDTO(CustomerDTO data){
        Customer customer = new Customer(data.getId(), data.getName(), data.getEmail(),data.getImage(), data.getCpf(), data.getPassword());
        return customer;
    }
}