package com.pandaserv.controllers;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.dto.MailDto;
import com.pandaserv.entity.AccountEntity;
import com.pandaserv.entity.MailEntity;
import com.pandaserv.service.mail.MailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mails")
public class MailController {

    private MailServiceImpl mailService;
    private ModelMapper modelMapper;

    public MailController(MailServiceImpl mailService, ModelMapper modelMapper) {
        this.mailService = mailService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<MailDto> getAllEvents() {
        List<MailEntity> entitiesList = mailService.readAll();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MailDto getAccountById(@PathVariable("id") int id) {
        return convertToDto(mailService.read(id));
    }

    @PostMapping("/")
    public void createAccount(@RequestBody MailDto mailDto) {
        mailService.create(convertToEntity(mailDto));
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody MailDto mailDto) {
        mailService.update(convertToEntity(mailDto), mailDto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        mailService.delete(id);
    }

    private MailDto convertToDto(MailEntity inputEntity) {
        return modelMapper.map(inputEntity, MailDto.class);
    }

    private MailEntity convertToEntity(MailDto inputDTO) {
        return modelMapper.map(inputDTO, MailEntity.class);
    }
}
