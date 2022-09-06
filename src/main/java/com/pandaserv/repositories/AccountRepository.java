package com.pandaserv.repositories;

import com.pandaserv.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAccountByName(String name);
    Account findAccountById(int id);

}
