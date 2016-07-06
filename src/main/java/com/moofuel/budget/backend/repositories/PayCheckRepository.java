package com.moofuel.budget.backend.repositories;

import com.moofuel.budget.backend.domain.entities.PayCheck;

import java.util.List;

/**
 * Created by MoOFueL on 07.07.2016.
 */
public interface PayCheckRepository extends AbstractRepository<PayCheck> {

    List<PayCheck> findByUserId(Integer userId);
}
