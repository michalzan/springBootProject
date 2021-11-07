package com.engeto.springBootProject.service.hl;

import com.engeto.springBootProject.model.BuyingOrder;
import com.engeto.springBootProject.model.Item;
import com.engeto.springBootProject.model.User;
import com.engeto.springBootProject.service.BuyingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public BuyingOrder createBuyingOrder(List<Item> items, User user) {
        BuyingOrder order = new BuyingOrder();
        items.forEach(item -> {
            itemHLService.orderItem(item.getName(), item.getAmount());
            order.getItems().add(item);
        });
        order.setUser(user);
        return order;
    }
}
