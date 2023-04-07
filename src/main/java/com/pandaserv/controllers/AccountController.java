package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/panda/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService service) {
        this.accountService = service;
    }

    @GetMapping("/all")
    public List<AccountDto> getAccounts() {
        return accountService.readAll();
    }

    @PostMapping("/")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.create(accountDto);
    }

    @PutMapping("/")
    public void updateAccount(@RequestBody AccountDto accountDto) {
        accountService.update(accountDto);
    }

    @DeleteMapping("/{name}")
    public void deleteAccount(@PathVariable("name") String name) {
        accountService.delete(name);
    }

    @DeleteMapping("/")
    public void deleteAccountTest(@RequestBody List<String> names) {
        accountService.deleteSelected(names);
    }

}
