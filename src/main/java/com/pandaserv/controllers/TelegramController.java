package com.pandaserv.controllers;

import com.pandaserv.entity.AccountEntity;
import com.pandaserv.service.account.AccountServiceImpl;
import com.pandaserv.telegrambot.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/telegram")
public class TelegramController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Bot bot;
    private AccountServiceImpl accountService;

    public TelegramController(Bot bot, AccountServiceImpl service) {
        this.bot = bot;
        this.accountService = service;
    }

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("sayHello");
//        bot.sendMessage("HelloWorld");
        return "Hello World";
    }

    @CrossOrigin(origins = "http://192.168.100.11:8080")
    @GetMapping("/getValue")
    public ResponseEntity<List<AccountEntity>> getValue() {
        logger.info("getValue");
        List<AccountEntity> accountEntities = accountService.readAll();
        return new ResponseEntity<>(accountEntities, HttpStatus.OK);
    }

}
