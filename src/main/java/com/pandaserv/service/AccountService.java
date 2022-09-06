package com.pandaserv.service;

import com.pandaserv.model.Account;

import java.util.List;

public interface AccountService {

    void create(Account account);

    List<Account> readAll();

    Account read(int id);

    boolean update(Account account, int id);

    boolean delete(int id);

}
