package com.engeto.springBootProject.service.hl;

import com.engeto.springBootProject.model.entity.Item;
import com.engeto.springBootProject.model.exception.BadRequestException;
import com.engeto.springBootProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemHLService {

    private final ItemService itemService;

    @Autowired
    public ItemHLService(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item addItem(String name, long amount) {
        Item item = itemService.getByName(name);
        if (item == null) {
            item = new Item(null, name, 0);
        }
        item.setAmount(item.getAmount() + amount);
        return itemService.saveItem(item);
    }

    public Item orderItem(String name, long amount) {
        Item item = itemService.getByName(name);
        if (!isItemAvailable(name, amount)) {
            throw new BadRequestException("Not enough items: " + name);
        }
        item.setAmount(item.getAmount() - amount);
        return itemService.saveItem(item);
    }

    private boolean isItemAvailable(String name, long amount) {
        Item item = itemService.getByName(name);
        return item != null && item.getAmount() >= amount;
    }

    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
