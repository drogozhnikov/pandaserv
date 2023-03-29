package com.pandaserv.service.account;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.entity.MailEntity;
import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.model.Type;
import com.pandaserv.repository.AccountRepository;
import com.pandaserv.service.mail.MailService;
import com.pandaserv.service.owner.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private MailService mailService;
    private OwnerService ownerService;
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void create(AccountDto accountDto) {
        accountRepository.save(convertToEntity(accountDto));
    }

    @Override
    public List<AccountDto> readAll() {
        List<AccountEntity> entitiesList = accountRepository.findAll();
        List<AccountDto> tempList = entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return tempList;
    }

    @Override
    public AccountDto read(int id) {
        return convertToDto(accountRepository.findAccountById(id));
    }

    @Override
    public boolean update(AccountDto accountDto) {
        Optional<AccountEntity> entity = Optional.ofNullable(accountRepository.findAccountByName(accountDto.getName()));
            if(entity.isPresent()){
                accountRepository.save(convertToEntity(accountDto));
            }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(accountRepository.existsById(id)){
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private AccountDto convertToDto(AccountEntity inputEntity) {
        return modelMapper.map(inputEntity, AccountDto.class);
    }

    private AccountEntity convertToEntity(AccountDto inputDTO) {
        System.out.println();
        MailEntity mailEntity = mailService.findMailEntityByMail(inputDTO.getMail());
        OwnerEntity ownerEntity = ownerService.findOwnerEntityByOwnerName(inputDTO.getOwner());

        AccountEntity entity = modelMapper.map(inputDTO, AccountEntity.class);
        entity.setMail(mailEntity);
        entity.setType(Type.valueOf(inputDTO.getType()));
        entity.setOwner(ownerEntity);
        return entity;
    }
}
