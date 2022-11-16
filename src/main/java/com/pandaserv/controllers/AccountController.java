package com.pandaserv.controllers;

import com.pandaserv.entity.AccountEntity;
import com.pandaserv.service.account.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl service) {
        this.accountService = service;
    }

    @GetMapping("/all")
    public List<AccountEntity> getAllEvents() {
        return accountService.readAll();
    }

    @GetMapping("/{id}")
    public AccountEntity getAccountById(@PathVariable("id") int id) {
        return accountService.read(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody AccountEntity account) {
        accountService.create(account);
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody AccountEntity account) {
        accountService.update(account, account.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        accountService.delete(id);
    }


}
