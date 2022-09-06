package com.pandaserv.service;

import com.pandaserv.model.Account;
import com.pandaserv.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> readAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account read(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public boolean update(Account account, int id) {
        if(accountRepository.existsById(id)){
            account.setId(id);
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(accountRepository.existsById(id)){
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
