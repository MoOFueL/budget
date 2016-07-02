package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Дмитрий on 02.07.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User saveForName(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }
}
