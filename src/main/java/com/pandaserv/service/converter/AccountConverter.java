package com.pandaserv.service.converter;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.model.Type;
import com.pandaserv.service.MailService;
import com.pandaserv.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountConverter {

    private MailService mailService;
    private OwnerService ownerService;

    public List<AccountDto> convertAllToDto(List<AccountEntity> inputList){
        return inputList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AccountDto convertToDto(AccountEntity inputEntity) {
        return AccountDto.builder()
                .id(inputEntity.getId())
                .name(inputEntity.getName())
                .account(inputEntity.getAccount())
                .password(inputEntity.getPassword())
                .link(inputEntity.getLink())
                .description(inputEntity.getDescription())
                .mail(inputEntity.getMail().getMail())
                .owner(inputEntity.getOwner().getOwnerName())
                .type(inputEntity.getType().name())
                .build();
    }

    public AccountEntity convertToEntity(AccountDto inputDTO) {
        return AccountEntity.builder()
                .id(inputDTO.getId())
                .name(inputDTO.getName())
                .account(inputDTO.getAccount())
                .password(inputDTO.getPassword())
                .link(inputDTO.getLink())
                .description(inputDTO.getDescription())
                .mail(mailService.findOrSaveAndGetMail(inputDTO.getMail()))
                .owner(ownerService.findOwnerEntityByOwnerName(inputDTO.getOwner()))
                .type(Type.valueOf(inputDTO.getType()))
                .build();
    }

}
