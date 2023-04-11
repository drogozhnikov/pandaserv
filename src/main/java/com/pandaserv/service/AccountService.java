package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.converter.AccountConverter;
import com.pandaserv.utils.JsonIO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private AccountConverter accountConverter;


    public AccountDto create(AccountDto accountDto) {
        AccountEntity entity =  accountRepository.save(accountConverter.convertToEntity(accountDto));
        return accountConverter.convertToDto(entity);
    }

    public void createMultiple(List<AccountDto> accountDtos) {
        for (AccountDto dto : accountDtos) {
            accountRepository.save(accountConverter.convertToEntity(dto));
        }
    }

    public AccountDto findAccountByName(String name) {
        Optional<AccountEntity> entity = accountRepository.findAccountByName(name);
        if (entity.isPresent()) {
           return  accountConverter.convertToDto(entity.get());
        }
        throw new PandaException("NotFound",HttpStatus.NOT_FOUND);
    }

    public List<AccountDto> readAll() {
        return accountConverter.convertAllToDto(accountRepository.findAll());
    }

    public AccountDto update(AccountDto accountDto) {
        Optional<AccountEntity> entity = accountRepository.findAccountByName(accountDto.getOldName());
        if (entity.isPresent()) {
            AccountEntity updatedEntity = accountConverter.convertToEntity(accountDto);
            updatedEntity.setId(entity.get().getId());
            updatedEntity = accountRepository.save(updatedEntity);
            return accountConverter.convertToDto(updatedEntity);
        }
        throw new PandaException("Update error", HttpStatus.BAD_REQUEST);
    }

    public void delete(String name) {
        Optional<AccountEntity> entity = accountRepository.findAccountByName(name);
        entity.ifPresent(mailEntity -> accountRepository.delete(mailEntity));
    }

}
