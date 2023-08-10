package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOperatorByIdService {

    @Autowired
    private OperatorRepository repository;

    public Operator getOperatorById(Long id){
        Operator operator = repository.findById(id).get();
        return operator;
    }

}