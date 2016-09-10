package com.moofuel.budget.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Author is D.Ivanov, created on 02.07.2016.
 */
@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
