package com.engeto.springBootProject.repository;

import com.engeto.springBootProject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    Item getByName(String name);

}
