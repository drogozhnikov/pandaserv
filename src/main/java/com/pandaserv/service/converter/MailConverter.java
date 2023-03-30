package com.pandaserv.service.converter;

import com.pandaserv.dto.MailDto;
import com.pandaserv.entity.MailEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MailConverter {

    public List<MailDto> convertAllToDto(List<MailEntity> inputList) {
        return inputList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public MailDto convertToDto(MailEntity inputEntity) {
        return MailDto.builder()
                .mail(inputEntity.getMail())
                .build();
    }

}
