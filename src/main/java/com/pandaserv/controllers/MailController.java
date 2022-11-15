package com.pandaserv.controllers;

import com.pandaserv.entity.MailEntity;
import com.pandaserv.service.mail.MailServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MailController {

    private MailServiceImpl mailService;

    public MailController(MailServiceImpl mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/mails/all")
    public List<MailEntity> getAllEvents() {
        return mailService.readAll();
    }

    @GetMapping("/mails/{id}")
    public MailEntity getAccountById(@PathVariable("id") int id) {
        return mailService.read(id);
    }

    @PostMapping("/mails")
    public void createAccount(@RequestBody MailEntity mailEntity) {
        mailService.create(mailEntity);
    }

    @PutMapping("/mails/")
    public void updateEvent(@RequestBody MailEntity mailEntity) {
        mailService.update(mailEntity, mailEntity.getId());
    }

    @DeleteMapping("/mails/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        mailService.delete(id);
    }
}
