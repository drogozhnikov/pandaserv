package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.utils.JsonIO;
import com.pandaserv.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class DataService {

    private final JsonIO jsonIO;
    private final PasswordGenerator passwordGenerator;

    @Value("${pg.pattern}")
    private String pattern;

    @Value("${json.template.path}")
    private String fileName;

    public DataService(JsonIO jsonIO, PasswordGenerator passwordGenerator) {
        this.jsonIO = jsonIO;
        this.passwordGenerator = passwordGenerator;
    }

    public List<AccountDto> readJson(MultipartFile file) {
        return jsonIO.jsonToEntity(file);
    }

    public String generatePassword() {
        return passwordGenerator.generatePassword(pattern);
    }

    public File getTemplateFile() throws IOException {
        File file = new ClassPathResource(fileName).getFile();;
        return file;
    }


}
