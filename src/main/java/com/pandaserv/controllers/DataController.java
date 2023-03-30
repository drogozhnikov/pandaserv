package com.pandaserv.controllers;

import com.pandaserv.dto.MailDto;
import com.pandaserv.dto.OwnerDto;
import com.pandaserv.model.Type;
import com.pandaserv.service.MailService;
import com.pandaserv.service.OwnerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/data")
public class DataController {

    private final MailService mailService;
    private final OwnerService ownerService;

    public DataController(MailService mailService, OwnerService ownerService) {
        this.mailService = mailService;
        this.ownerService = ownerService;
    }

    @GetMapping("/mails")
    public List<MailDto> getMails() {
        return mailService.readAll();
    }

    @GetMapping("/owners")
    public List<OwnerDto> getOwners() {
        return ownerService.readAll();
    }

    @GetMapping("/types")
    public List<Type> getTypes() {
        return Arrays.stream(Type.values()).collect(Collectors.toList());
    }
}
