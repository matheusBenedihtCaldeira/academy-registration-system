package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {

    @Autowired
    private CustomerRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }

}