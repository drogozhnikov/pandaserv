package com.pandaserv.service.account;

import com.pandaserv.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void create(AccountDto accountDto);

    List<AccountDto> readAll();

    AccountDto read(int id);

    boolean update(AccountDto accountDto);
    boolean delete(int id);

}
