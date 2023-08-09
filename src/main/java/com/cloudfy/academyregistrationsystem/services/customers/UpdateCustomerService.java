package com.cloudfy.academyregistrationsystem.services.customers;

import com.cloudfy.academyregistrationsystem.models.dto.CustomerDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Customer;
import com.cloudfy.academyregistrationsystem.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer update(Customer data){
        Customer customerToUpdate = findById(data.getId());
        updateData(customerToUpdate, data);
        return repository.save(customerToUpdate);
    }

    public void updateData(Customer customerFromDB, Customer customerToUpdate){
        customerFromDB.setName(customerToUpdate.getName());
        customerFromDB.setEmail(customerToUpdate.getEmail());
        customerFromDB.setCpf(customerToUpdate.getCpf());
        customerFromDB.setPassword(customerToUpdate.getPassword());
    }

    public Customer findById(Long id){
        Customer customer = repository.findById(id).get();
        return customer;
    }
    public Customer fromDTO(CustomerDTO data){
        return new Customer(data.getId(),data.getName(),data.getEmail(),data.getCpf(),data.getPassword());
    }
}