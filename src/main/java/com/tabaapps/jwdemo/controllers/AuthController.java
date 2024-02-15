package com.tabaapps.jwdemo.controllers;

import com.tabaapps.jwdemo.services.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping(path = "/login")
    public String login(Authentication authentication) {
        return tokenService.generate(authentication);
        //return authentication.getName();
    }

}
