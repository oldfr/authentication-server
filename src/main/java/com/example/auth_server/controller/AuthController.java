package com.example.auth_server.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Value("${jwt.secret}")
    private String secret;

    @GetMapping
    public String getToken() {
        System.out.println("inside auth login");
        return Jwts.builder()
                .claim("id","ankitha")
                .claim("role","admin")
                .setSubject("Test Token")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256,secret).compact();
    }
}
