package com.engeto.springBootProject.service;

import com.engeto.springBootProject.model.entity.User;
import com.engeto.springBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
