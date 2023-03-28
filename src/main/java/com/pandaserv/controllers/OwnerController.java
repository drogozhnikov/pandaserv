package com.pandaserv.controllers;

import com.pandaserv.dto.MailDto;
import com.pandaserv.dto.OwnerDto;
import com.pandaserv.entity.MailEntity;
import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.service.owner.OwnerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/owners")
public class OwnerController {

    private OwnerServiceImpl ownerService;
    private ModelMapper modelMapper;

    public OwnerController(OwnerServiceImpl ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<OwnerDto> getAllEvents() {
        List<OwnerEntity> entitiesList = ownerService.readAll();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OwnerDto getAccountById(@PathVariable("id") int id) {
        return convertToDto(ownerService.read(id));
    }

    @PostMapping("/")
    public void createAccount(@RequestBody OwnerDto ownerDto) {
        ownerService.create(convertToEntity(ownerDto));
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody OwnerDto ownerDto) {
        ownerService.update(convertToEntity(ownerDto), ownerDto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        ownerService.delete(id);
    }

    private OwnerDto convertToDto(OwnerEntity inputEntity) {
        return modelMapper.map(inputEntity, OwnerDto.class);
    }

    private OwnerEntity convertToEntity(OwnerDto inputDTO) {
        return modelMapper.map(inputDTO, OwnerEntity.class);
    }
}
