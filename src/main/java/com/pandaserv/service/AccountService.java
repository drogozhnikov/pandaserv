package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.converter.AccountConverter;
import lombok.AllArgsConstructor;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private AccountConverter accountConverter;

    public int create(AccountDto accountDto) {
        AccountEntity account = accountRepository.save(accountConverter.convertToEntity(accountDto));
        return account.getId();
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

    public void delete(int id) {
        Optional<AccountEntity> entity = accountRepository.findAccountById(id);
        entity.ifPresent(mailEntity -> accountRepository.delete(mailEntity));
    }


}
