package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.dto.OperatorDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.services.operator.UpdateOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "/operator/update")
public class UpdateOperatorCotroller {

    @Autowired
    private UpdateOperatorService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Operator> update(@RequestBody OperatorDTO data, @PathVariable Long id){
        Operator operator = service.fromDTO(data);
        operator.setId(id);
        service.update(operator);
        return ResponseEntity.noContent().build();
    }
}
