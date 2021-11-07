package com.engeto.springBootProject.controller;

import com.engeto.springBootProject.model.request.AddItemRequest;
import com.engeto.springBootProject.service.hl.ItemHLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemHLService service;

    @Autowired
    public ItemController(ItemHLService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> addItem(@Valid @RequestBody AddItemRequest request) {
        service.addItem(request.getName(), request.getAmount());
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.of(Optional.of(service.getAllItems()));
    }

}
