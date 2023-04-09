package com.pandaserv.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandaserv.dto.AccountDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@NoArgsConstructor
public class JsonIO {

    public List<AccountDto> jsonToEntity(String fileName) {
        List<AccountDto> dtoList = null;
        try {
            File file = new ClassPathResource(fileName).getFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            dtoList = mapper.readValue(file, new TypeReference<List<AccountDto>>() {
            });
        } catch (Exception e) {
            System.out.println("Smth Wrong");
        }
        return dtoList;
    }

}
