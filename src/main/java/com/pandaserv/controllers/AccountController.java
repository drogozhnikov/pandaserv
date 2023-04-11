package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/pwd")
    public String getPassword(@RequestParam String name) {
        return accountService.findAccountByName(name).getPassword();
    }

    @PostMapping("/")
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.create(accountDto);
    }

    @PutMapping("/")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.update(accountDto);
    }

    @DeleteMapping("/{name}")
    public void deleteAccount(@PathVariable("name") String name) {
        accountService.delete(name);
    }

}
