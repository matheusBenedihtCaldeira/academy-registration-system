package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexOperatorsService {

    @Autowired
    private OperatorRepository repository;

    public List<Operator> index(){
        List<Operator> list = repository.findAll();
        return list;
    }
}