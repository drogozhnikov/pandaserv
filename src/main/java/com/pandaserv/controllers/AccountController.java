package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin //needed to Vue
@RequestMapping("/api/panda/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService service) {
        this.accountService = service;
    }

    @GetMapping("/all")
    public List<AccountDto> getAccounts(@RequestHeader(value = "user") String authorization) {
        return accountService.readAll(authorization);
    }

    @PostMapping("/")
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.create(accountDto);
    }

    @PutMapping("/")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.update(accountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") int id) {
        accountService.delete(id);
    }

    @DeleteMapping("/")
    public void deleteAccount(@RequestHeader(value = "user") String userName) {
        accountService.deleteAll(userName);
    }

}
