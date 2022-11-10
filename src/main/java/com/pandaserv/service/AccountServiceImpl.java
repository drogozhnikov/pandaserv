package com.pandaserv.service;

import com.pandaserv.entity.AccountEntity;
import com.pandaserv.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }

    @Override
    public List<AccountEntity> readAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity read(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public boolean update(AccountEntity accountEntity, int id) {
        if(accountRepository.existsById(id)){
            accountEntity.setId(id);
            accountRepository.save(accountEntity);
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
