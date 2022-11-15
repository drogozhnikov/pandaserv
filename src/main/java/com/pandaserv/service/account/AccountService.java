package com.pandaserv.service.account;

import com.pandaserv.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    void create(AccountEntity accountEntity);

    List<AccountEntity> readAll();

    AccountEntity read(int id);

    boolean update(AccountEntity accountEntity, int id);

    boolean delete(int id);

}
