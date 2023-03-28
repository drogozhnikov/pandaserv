package com.pandaserv.controllers;

import com.pandaserv.dto.TypeDto;
import com.pandaserv.entity.TypeEntity;
import com.pandaserv.service.type.TypeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/types")
public class TypeController {

    private TypeServiceImpl typeService;
    private ModelMapper modelMapper;

    public TypeController(TypeServiceImpl typeService, ModelMapper modelMapper) {
        this.typeService = typeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<TypeDto> getAllEvents() {
        List<TypeEntity> entitiesList = typeService.readAll();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TypeDto getAccountById(@PathVariable("id") int id) {
        return convertToDto(typeService.read(id));
    }

    @PostMapping("/")
    public void createAccount(@RequestBody TypeDto typeDto) {
        typeService.create(convertToEntity(typeDto));
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody TypeDto typeDto) {
        typeService.update(convertToEntity(typeDto), typeDto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        typeService.delete(id);
    }

    private TypeDto convertToDto(TypeEntity inputEntity) {
        return modelMapper.map(inputEntity, TypeDto.class);
    }

    private TypeEntity convertToEntity(TypeDto inputDTO) {
        return modelMapper.map(inputDTO, TypeEntity.class);
    }
}
