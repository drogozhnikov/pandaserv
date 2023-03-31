package com.pandaserv.appconfig;

import com.pandaserv.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ApplicationConfiguration {

    @Bean
    public MessageService getMessageSerivice(MessageSource messageSource) {
        return new MessageService(messageSource);
    }

}
