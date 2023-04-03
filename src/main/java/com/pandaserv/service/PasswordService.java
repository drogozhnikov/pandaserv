package com.pandaserv.service;


import com.pandaserv.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordGenerator passwordGenerator;

    @Value("${pg.pattern}")
    private String pattern;

    public PasswordService() {
        this.passwordGenerator = new PasswordGenerator();
    }

    public String generatePassword() {
        return passwordGenerator.generatePassword(pattern);
    }

}
