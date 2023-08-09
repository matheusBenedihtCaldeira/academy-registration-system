package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/operators")
public class IndexOperatorsController {

    @GetMapping
    public ResponseEntity<Operator> index(){
        Operator operator = new Operator(1L, "Matheus", "matheus@teste.com","EBYO", "123456");
        return ResponseEntity.ok().body(operator);
    }
}