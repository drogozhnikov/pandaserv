package com.pandaserv.controllers;

import com.pandaserv.model.Account;
import com.pandaserv.service.AccountServiceImpl;
import com.pandaserv.telegrambot.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Bot bot;
    private AccountServiceImpl accountService;

    public StartController(Bot bot, AccountServiceImpl service) {
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
    public ResponseEntity<List<Account>> getValue() {
        logger.info("getValue");
        List<Account> accounts = accountService.readAll();
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }

}
