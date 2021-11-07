package com.engeto.springBootProject.repository;

import com.engeto.springBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserByLogin(String login);

}
