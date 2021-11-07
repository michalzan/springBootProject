package com.engeto.springBootProject.repository;

import com.engeto.springBootProject.model.BuyingOrder;
import com.engeto.springBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BuyingOrderRepository extends JpaRepository<BuyingOrder, UUID> {

    List<BuyingOrder> getBuyingOrderByUser(User user);

}
