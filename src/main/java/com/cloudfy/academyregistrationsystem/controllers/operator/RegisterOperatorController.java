package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.dto.OperatorDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.services.operator.RegisterOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping("/register/operator")
public class RegisterOperatorController {

    @Autowired
    private RegisterOperatorService service;

    @PostMapping
    public ResponseEntity<Operator> register(@RequestBody OperatorDTO data){
        Operator operator = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(operator.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}