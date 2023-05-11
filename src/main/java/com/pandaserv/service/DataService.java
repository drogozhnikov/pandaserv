package com.pandaserv.service;

import com.pandaserv.dto.AccountDto;
import com.pandaserv.exception.PandaException;
import com.pandaserv.utils.JsonIO;
import com.pandaserv.utils.PasswordGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
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

    public List<AccountDto> readJson(String username, MultipartFile file) {
        List<AccountDto> inputList = jsonIO.jsonToEntity(file);
        List<AccountDto> filteredList = jsonIO.filterByUserName(username, inputList);
        if(inputList.size()!=filteredList.size()){
            throw new PandaException("Username missmatch found. Check Json file.", HttpStatus.BAD_REQUEST);
        }
        return filteredList;
    }

    public String generatePassword() {
        return passwordGenerator.generatePassword(pattern);
    }

    public File getTemplateFile() throws IOException {
        File file = new ClassPathResource(fileName).getFile();;
        return file;
    }

}
