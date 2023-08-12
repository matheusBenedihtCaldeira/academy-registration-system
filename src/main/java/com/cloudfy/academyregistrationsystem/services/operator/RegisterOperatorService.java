package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.models.dto.OperatorDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterOperatorService {

    @Autowired
    private OperatorRepository repository;

    public Operator register(OperatorDTO data){
        Operator operator = fromDTO(data);
        return repository.save(operator);
    }

    public Operator fromDTO(OperatorDTO data){
        return new Operator(data.getId(),data.getName(),data.getEmail(),data.getOperatorKey(),data.getPassword(),data.getRole());
    }

}