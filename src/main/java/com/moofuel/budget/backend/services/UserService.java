package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MoOFueL on 02.07.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Integer userId) {
        return userRepository.findById(userId);
    }
}
