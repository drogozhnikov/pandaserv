package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.converter.AccountConverter;
import com.pandaserv.utils.JsonIO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private AccountConverter accountConverter;


    public void create(AccountDto accountDto) {
        accountRepository.save(accountConverter.convertToEntity(accountDto));
    }

    public void createMultiple(List<AccountDto> accountDtos){
        for(AccountDto dto: accountDtos){
            accountRepository.save(accountConverter.convertToEntity(dto));
        }
    }

    public List<AccountDto> readAll() {
        return accountConverter.convertAllToDto(accountRepository.findAll());
    }

    public void update(AccountDto accountDto) {
        Optional<AccountEntity> entity = accountRepository.findAccountByName(accountDto.getOldName());
        if (entity.isPresent()) {
            AccountEntity updatedEntity = accountConverter.convertToEntity(accountDto);
            updatedEntity.setId(entity.get().getId());
            accountRepository.save(updatedEntity);
        }
    }

    public void delete(String name) {
        Optional<AccountEntity> entity = accountRepository.findAccountByName(name);
        entity.ifPresent(mailEntity -> accountRepository.delete(mailEntity));
    }

}
