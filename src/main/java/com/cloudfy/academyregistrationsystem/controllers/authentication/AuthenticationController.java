package com.cloudfy.academyregistrationsystem.controllers.authentication;

import com.cloudfy.academyregistrationsystem.models.dto.AuthenticationDTO;
import com.cloudfy.academyregistrationsystem.infra.security.TokenService;
import com.cloudfy.academyregistrationsystem.models.dto.LoginResponseDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/operator")
    public ResponseEntity  login (@RequestBody @Valid AuthenticationDTO data){
        var user = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(user);

        var token = tokenService.generateToken((Operator) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}