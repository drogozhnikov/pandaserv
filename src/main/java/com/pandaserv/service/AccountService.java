package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.converter.AccountConverter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private AccountConverter accountConverter;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void create(AccountDto accountDto) {
        accountRepository.save(accountConverter.convertToEntity(accountDto));
    }

    public List<AccountDto> readAll() {
        return accountConverter.convertAllToDto(accountRepository.findAll());
    }

    public void update(AccountDto accountDto) {
        Optional<AccountEntity> entity = accountRepository.findAccountById(accountDto.getId());
        if (entity.isPresent()) {
            AccountEntity updatedEntity = accountConverter.convertToEntity(accountDto);
            updatedEntity.setId(entity.get().getId());
            accountRepository.save(updatedEntity);
        }
    }

    public void delete(AccountDto accountDto) {
        if (Optional.ofNullable(accountDto).isPresent()) {
            Optional<AccountEntity> entity = accountRepository.findAccountByName(accountDto.getName());
            entity.ifPresent(mailEntity -> accountRepository.delete(mailEntity));
        }
    }


}
