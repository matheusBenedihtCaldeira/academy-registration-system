package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteOperatorService {

    @Autowired
    private OperatorRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}