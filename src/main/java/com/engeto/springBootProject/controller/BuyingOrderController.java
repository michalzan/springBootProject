package com.engeto.springBootProject.controller;

import com.engeto.springBootProject.model.entity.BuyingOrder;
import com.engeto.springBootProject.model.request.BuyingOrderRequest;
import com.engeto.springBootProject.model.request.ConfirmOrderRequest;
import com.engeto.springBootProject.service.hl.BuyingOrderHLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class BuyingOrderController {

    private final BuyingOrderHLService service;

    @Autowired
    public BuyingOrderController(BuyingOrderHLService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<BuyingOrder> getOrders() {
        return service.getOrders();
    }

    @GetMapping("/pending")
    public List<BuyingOrder> getPendingOrders() {
        return service.getPendingOrders();
    }

    @PostMapping("")
    public BuyingOrder createBuyingOrder(@Valid @RequestBody BuyingOrderRequest request) {
        return service.createBuyingOrder(request.getItems(), request.getAddress());
    }

    @PostMapping("/confirm")
    public BuyingOrder confirmBuyingOrder(@RequestBody ConfirmOrderRequest request) {
        return service.confirmOrder(request.getOrderId());
    }
}
