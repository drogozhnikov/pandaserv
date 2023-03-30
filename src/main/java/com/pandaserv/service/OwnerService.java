package com.pandaserv.service;

import com.pandaserv.dto.OwnerDto;
import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.OwnerRepository;
import com.pandaserv.service.converter.OwnerConverter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerConverter ownerConverter;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OwnerEntity create(OwnerEntity ownerEntity) {
        return ownerRepository.save(ownerEntity);
    }

    public List<OwnerDto> readAll() {
        return ownerConverter.convertAllToDto(ownerRepository.findAll());
    }

    public OwnerEntity findOwnerEntityByOwnerName(String name) {
        if (Optional.ofNullable(name).isPresent()) {
            return ownerRepository.findOwnerEntityByOwnerName(name).orElseGet(() -> ownerRepository.save(new OwnerEntity(name)));
        }
        throw new PandaException("Please give mail", HttpStatus.BAD_REQUEST);
    }

    public void delete(OwnerDto ownerDto) {
        if (Optional.ofNullable(ownerDto).isPresent()) {
            Optional<OwnerEntity> entity = ownerRepository.findOwnerEntityByOwnerName(ownerDto.getName());
            entity.ifPresent(ownerEntity -> ownerRepository.delete(ownerEntity));
        }
    }
}
