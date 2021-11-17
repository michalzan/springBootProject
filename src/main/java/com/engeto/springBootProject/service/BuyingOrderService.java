package com.engeto.springBootProject.service;

import com.engeto.springBootProject.model.entity.BuyingOrder;
import com.engeto.springBootProject.repository.BuyingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuyingOrderService {

    private final BuyingOrderRepository buyingOrderRepository;

    @Autowired
    public BuyingOrderService(BuyingOrderRepository buyingOrderRepository) {
        this.buyingOrderRepository = buyingOrderRepository;
    }

    public BuyingOrder getBuyingOrder(UUID id) {
        return buyingOrderRepository.getById(id);
    }

    public List<BuyingOrder> getAllBuyingOrders() {
        return buyingOrderRepository.findAll();
    }

    public List<BuyingOrder> getPendingBuyingOrders() {
        return buyingOrderRepository.getAllByPending(true);
    }

    public BuyingOrder saveBuyingOrder(BuyingOrder order) {
        return buyingOrderRepository.save(order);
    }

}
