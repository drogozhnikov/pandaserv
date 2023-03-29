package com.pandaserv.repository;

import com.pandaserv.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findAccountByName(String name);

    List<AccountEntity> findAll();

    AccountEntity findAccountById(int id);

    void deleteById(int id);

}
