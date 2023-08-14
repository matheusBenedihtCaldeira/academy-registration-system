package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import com.cloudfy.academyregistrationsystem.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOperatorByIdService {

    @Autowired
    private OperatorRepository repository;

    public Operator getOperatorById(Long id){
        Optional<Operator> operator = repository.findById(id);
        return operator.orElseThrow(() -> new ObjectNotFoundException("Operator not found!"));
    }

}