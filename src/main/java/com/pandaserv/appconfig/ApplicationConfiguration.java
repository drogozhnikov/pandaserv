package com.pandaserv.appconfig;

import com.pandaserv.service.MessageService;
import com.pandaserv.telegrambot.Bot;
import com.pandaserv.telegrambot.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class ApplicationConfiguration {

    Bot bot;

    @Bean
    public MessageService getMessageSerivice(MessageSource messageSource) {
        return new MessageService(messageSource);
    }

    @PostConstruct
    public void registerTelegramBot() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Storage storageBean() {
        return new Storage();
    }

    @Autowired
    public void setBot(Bot bot) {
        this.bot = bot;
    }


}
