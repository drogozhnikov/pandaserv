package com.pandaserv.controllers;

import com.pandaserv.model.Account;
import com.pandaserv.service.AccountService;
import com.pandaserv.service.AccountServiceImpl;
import com.pandaserv.telegrambot.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Bot bot;
    private AccountServiceImpl accountService;

    @GetMapping("/hello")
    public String sayHello(){
        logger.info("sayHello");
//        bot.sendMessage("HelloWorld");
        return "Hello World";
    }
    @GetMapping("/getValue")
    public String getValue(){
        logger.info("getValue");
        List<Account> accounts = accountService.readAll();
        logger.info(accounts.get(0).toString());
        return accounts.get(0).toString();
    }

    @Autowired
    public void setBot(Bot bot) {
        this.bot = bot;
    }

    @Autowired
    public void setBot(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
}
