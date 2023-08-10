package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.services.operator.GetOperatorByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/operator")
public class GetOperatorByIdController {

    @Autowired
    private GetOperatorByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable Long id){
        Operator operator = service.getOperatorById(id);
        return ResponseEntity.ok().body(operator);
    }

}