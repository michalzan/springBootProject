package com.engeto.springBootProject.service.hl;

import com.engeto.springBootProject.model.entity.User;
import com.engeto.springBootProject.model.exception.DuplicateEntityException;
import com.engeto.springBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHLService {

    private final UserService service;

    @Autowired
    public UserHLService(UserService service) {
        this.service = service;
    }

    public User createUser(String login, String password) {
        if (service.getUserByLogin(login) != null) {
            throw new DuplicateEntityException("User with this name already exists!");
        }

        return service.createUser(new User(null, login, password, false));
    }

}
