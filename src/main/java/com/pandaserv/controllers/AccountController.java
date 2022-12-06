package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.service.account.AccountServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountServiceImpl accountService;
    private ModelMapper modelMapper;

    public AccountController(AccountServiceImpl service, ModelMapper modelMapper) {
        this.accountService = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<AccountDto> getAllEvents() {
        List<AccountEntity> entitiesList = accountService.readAll();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable("id") int id) {
        return convertToDto(accountService.read(id));
    }

    @PostMapping("/")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.create(convertToEntity(accountDto));
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody AccountDto accountDto) {
        accountService.update(convertToEntity(accountDto), accountDto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        accountService.delete(id);
    }


    private AccountDto convertToDto(AccountEntity inputEntity) {
        return modelMapper.map(inputEntity, AccountDto.class);
    }

    private AccountEntity convertToEntity(AccountDto inputDTO) {
        return modelMapper.map(inputDTO, AccountEntity.class);
    }

}
