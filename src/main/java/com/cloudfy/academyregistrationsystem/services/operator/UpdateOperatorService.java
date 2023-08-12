package com.cloudfy.academyregistrationsystem.services.operator;

import com.cloudfy.academyregistrationsystem.models.dto.OperatorDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.repositories.customer.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOperatorService {

    @Autowired
    private OperatorRepository repository;

    public Operator update(Operator dataToUpdate){
        Operator operatorFromDB = findById(dataToUpdate.getId());
        updateData(operatorFromDB, dataToUpdate);
        return repository.save(operatorFromDB);
    }

    public void updateData(Operator operatorFromDB, Operator dataToUpdate){
        operatorFromDB.setName(dataToUpdate.getName());
        operatorFromDB.setEmail(dataToUpdate.getEmail());
        operatorFromDB.setOperatorKey(dataToUpdate.getOperatorKey());
        operatorFromDB.setPassword(dataToUpdate.getPassword());
    }

    public Operator findById(Long id){
        Operator operator = repository.findById(id).get();
        return operator;
    }

    public Operator fromDTO(OperatorDTO data){
        return new Operator(data.getId(), data.getName(),data.getEmail(),data.getOperatorKey(),data.getPassword(), data.getRole());
    }

}