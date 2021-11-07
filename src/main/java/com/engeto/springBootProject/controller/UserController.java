package com.engeto.springBootProject.controller;

import com.engeto.springBootProject.model.request.RegisterRequest;
import com.engeto.springBootProject.service.hl.UserHLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserHLService service;

    @Autowired
    public UserController(UserHLService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        service.createUser(request.getLogin(), request.getPassword());
        return ResponseEntity.ok().build();
    }

}
