package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.services.operator.IndexOperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/operator")
public class IndexOperatorsController {

    @Autowired
    private IndexOperatorsService service;

    @GetMapping(value = "/index")
    public ResponseEntity<List<Operator>> index(){
        List<Operator> list = service.index();
        return ResponseEntity.ok().body(list);
    }
}