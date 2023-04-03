package com.pandaserv.controllers;

import com.pandaserv.dto.MailDto;
import com.pandaserv.dto.OwnerDto;
import com.pandaserv.model.Type;
import com.pandaserv.service.MailService;
import com.pandaserv.service.OwnerService;
import com.pandaserv.service.PasswordService;
import com.pandaserv.utils.PasswordGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin //needed to Vue
@RequestMapping("/api/panda/data")
@AllArgsConstructor
public class DataController {

    private MailService mailService;
    private OwnerService ownerService;
    private PasswordService passwordService;

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

    @GetMapping("/passgen")
    public String generatePassword() {
        return passwordService.generatePassword();
    }

}
