package com.pandaserv.controllers;

import com.pandaserv.entity.AccountEntity;
import com.pandaserv.service.account.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl service) {
        this.accountService = service;
    }

    @GetMapping("/accounts/all")
    public List<AccountEntity> getAllEvents() {
        return accountService.readAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountEntity getAccountById(@PathVariable("id") int id) {
        return accountService.read(id);
    }

    @PostMapping("/accounts")
    public void createAccount(@RequestBody AccountEntity account) {
        accountService.create(account);
    }

    @PutMapping("/accounts/")
    public void updateEvent(@RequestBody AccountEntity account) {
        accountService.update(account, account.getId());
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        accountService.delete(id);
    }


}
