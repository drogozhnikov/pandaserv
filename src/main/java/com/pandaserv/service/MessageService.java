package com.pandaserv.service;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

}
