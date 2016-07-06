package com.moofuel.budget.backend.repositories;

import com.moofuel.budget.backend.domain.entities.User;

/**
 * Created by MoOFueL on 02.07.2016.
 */
public interface UserRepository extends AbstractRepository<User>{

    User findById(Integer id);
}
