package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.service.account.AccountServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountServiceImpl accountService;
    private ModelMapper modelMapper;

    public AccountController(AccountServiceImpl service, ModelMapper modelMapper) {
        this.accountService = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<AccountDto> getAllAccounts() {
        return accountService.readAll();
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable("id") int id) {
        return accountService.read(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.create(accountDto);
    }

    @PutMapping("/")
    public void updateAccount(@RequestBody AccountDto accountDto) {
        accountService.update(accountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") int id) {
        accountService.delete(id);
    }

}
