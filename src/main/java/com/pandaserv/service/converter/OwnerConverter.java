package com.pandaserv.service.converter;

import com.pandaserv.dto.OwnerDto;
import com.pandaserv.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerConverter {

    public List<OwnerDto> convertAllToDto(List<OwnerEntity> inputList) {
        return inputList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OwnerDto convertToDto(OwnerEntity inputEntity) {
        return OwnerDto.builder()
                .name(inputEntity.getOwnerName())
                .build();
    }

}
