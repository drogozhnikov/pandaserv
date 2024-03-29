package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.converter.AccountConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private AccountConverter accountConverter;
    private OwnerService ownerService;

    public AccountDto create(AccountDto accountDto) {
        AccountEntity entity = accountRepository.save(accountConverter.convertToEntity(accountDto));
        return accountConverter.convertToDto(entity);
    }

    public void loadJson(String username, List<AccountDto> accountDtos) {
        for (AccountDto dto : accountDtos) {
            accountRepository.save(accountConverter.convertToEntity(dto));
        }
    }

    public void replaceAll(String username, List<AccountDto> accountDtos) {
        deleteAll(username);
        for (AccountDto dto : accountDtos) {
            accountRepository.save(accountConverter.convertToEntity(dto));
        }
    }

    public List<AccountDto> readAll(String owner) {
        OwnerEntity ownerEntity = ownerService.findOwnerEntityByOwnerName(owner);
        List<AccountEntity> entityList = accountRepository.findAllByOwnerEquals(ownerEntity);
        if (!entityList.isEmpty()) {
            return accountConverter.convertAllToDto(entityList);
        }
        return new ArrayList<>();
    }

    public AccountDto update(AccountDto accountDto) {
        Optional<AccountEntity> entity = accountRepository.findAccountById(accountDto.getId());
        if (entity.isPresent()) {
            AccountEntity updatedEntity = accountConverter.convertToEntity(accountDto);
            updatedEntity.setId(entity.get().getId());
            updatedEntity = accountRepository.save(updatedEntity);
            return accountConverter.convertToDto(updatedEntity);
        }
        throw new PandaException("Update error", HttpStatus.BAD_REQUEST);
    }

    public void delete(int id) {
        Optional<AccountEntity> entity = accountRepository.findAccountById(id);
        entity.ifPresent(mailEntity -> accountRepository.delete(mailEntity));
    }

    public void deleteAll(String username){
        OwnerEntity owner = ownerService.findOwnerEntityByOwnerName(username);
        List<AccountEntity> ownerList = accountRepository.findAllByOwnerEquals(owner);
            if(ownerList.size()>0){
                accountRepository.deleteAll(ownerList);
            }
    }

}
