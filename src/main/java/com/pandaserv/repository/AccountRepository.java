package com.pandaserv.repository;

import com.pandaserv.entity.AccountEntity;
import com.pandaserv.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    Optional<AccountEntity> findAccountByName(String name);
    Optional<AccountEntity> findAccountById(Integer id);

    List<AccountEntity> findAccountEntitiesByOwner(OwnerEntity owner);

    List<AccountEntity> findAll();

    List<AccountEntity> findAllByOwnerEquals(OwnerEntity owner);
 }
