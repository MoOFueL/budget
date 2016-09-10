package com.moofuel.budget.backend.repositories;

import com.moofuel.budget.backend.domain.entities.User;

/**
 * Author is D.Ivanov, created on 02.07.2016.
 */
public interface UserRepository extends AbstractRepository<User>{

    User findById(Integer id);

    User findByFioAndPassword(String fio, String password);
}
