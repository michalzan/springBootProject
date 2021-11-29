package com.engeto.springBootProject.service.hl;

import com.engeto.springBootProject.model.entity.BuyingOrder;
import com.engeto.springBootProject.model.entity.BuyingOrderItem;
import com.engeto.springBootProject.model.entity.Item;
import com.engeto.springBootProject.model.exception.ForbiddenException;
import com.engeto.springBootProject.model.exception.NotFoundException;
import com.engeto.springBootProject.model.request.OrderItem;
import com.engeto.springBootProject.service.BuyingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyingOrderHLService {

    private final BuyingOrderService buyingOrderService;
    private final ItemHLService itemHLService;

    @Autowired
    public BuyingOrderHLService(BuyingOrderService buyingOrderService, ItemHLService itemHLService) {
        this.buyingOrderService = buyingOrderService;
        this.itemHLService = itemHLService;
    }

    @Transactional
    public BuyingOrder createBuyingOrder(List<OrderItem> orderItems, String address) {
        if (address == null || address.isEmpty()) throw new ForbiddenException("Unknown address!");
        List<BuyingOrderItem> validItems = new ArrayList<>();
        BuyingOrder order = new BuyingOrder();
        orderItems.forEach(orderItem -> {
            Item item = itemHLService.orderItem(orderItem.getItemName(), orderItem.getAmount());
            validItems.add(new BuyingOrderItem(null, item, order, orderItem.getAmount()));
        });
        order.setItems(validItems);
        order.setAddress(address);
        order.setPending(true);
        return buyingOrderService.saveBuyingOrder(order);
    }

    public BuyingOrder confirmOrder(UUID orderId) {
        BuyingOrder order = buyingOrderService.getBuyingOrder(orderId);
        if (order == null) {
            throw new NotFoundException("Order not found!");
        }
        order.setPending(false);
        return buyingOrderService.saveBuyingOrder(order);
    }

    public List<BuyingOrder> getOrders() {
        return buyingOrderService.getAllBuyingOrders();
    }

    public List<BuyingOrder> getPendingOrders() {
        return buyingOrderService.getPendingBuyingOrders();
    }

}
