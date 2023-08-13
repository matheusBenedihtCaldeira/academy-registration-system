package com.cloudfy.academyregistrationsystem.controllers.operator;

import com.cloudfy.academyregistrationsystem.models.dto.AuthenticationDTO;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import com.cloudfy.academyregistrationsystem.services.operator.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String  login (@RequestBody @Valid AuthenticationDTO data){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var user = (Operator)authenticate.getPrincipal();

        return tokenService.generateToken(user);
    }

}