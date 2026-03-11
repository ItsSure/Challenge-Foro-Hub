package com.foro.hub.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.hub.dtos.UserDto;
import com.foro.hub.models.User;
import com.foro.hub.security.TokenJWT;
import com.foro.hub.security.Token;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private Token service;

    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<?> login(@Valid @RequestBody UserDto user) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(user.username(), user.password());
        var autenticacion = manager.authenticate(authenticationToken);
        var tokenJWT = service.generateToken((User) autenticacion.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
