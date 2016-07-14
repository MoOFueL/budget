package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.exceptions.BudgetInternalException;
import com.moofuel.budget.backend.exceptions.NotFoundException;
import com.moofuel.budget.backend.misc.AuthObject;
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

    public User findByCredentials(final AuthObject authObject) {

        final String fio = authObject.getFio();
        final String password = authObject.getPassword();
        User user = userRepository.findByFioAndPassword(fio, password);
        if (user == null) {
            throw new NotFoundException("User not found!");
        }
        return user;
    }

    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new BudgetInternalException("Can't update User entity!");
        }
        return userRepository.save(user);
    }
}
