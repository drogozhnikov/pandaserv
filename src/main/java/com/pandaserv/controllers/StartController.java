package com.pandaserv.controllers;

import com.pandaserv.telegrambot.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Bot bot;

    @GetMapping("/")
    public String sayHello(){
        logger.info("sayHello");
        bot.sendMessage("HelloWorld");
        return "Hello World";
    }

    @Autowired
    public void setBot(Bot bot) {
        this.bot = bot;
    }
}
