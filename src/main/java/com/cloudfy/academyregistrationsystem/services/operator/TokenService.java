package com.cloudfy.academyregistrationsystem.services.operator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cloudfy.academyregistrationsystem.models.entities.Operator;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(Operator operator){
        return JWT.create()
                .withIssuer("Customers")
                .withSubject(operator.getEmail())
                .withClaim("id", operator.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("senha"));
    }
}