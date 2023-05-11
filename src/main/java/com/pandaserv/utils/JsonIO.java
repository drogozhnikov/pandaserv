package com.pandaserv.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandaserv.dto.AccountDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class JsonIO {

    public List<AccountDto> jsonToEntity(MultipartFile inputFile) {
        List<AccountDto> dtoList = null;
        try {
            File file = convertMultiPartToFile(inputFile);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                dtoList = mapper.readValue(file, new TypeReference<List<AccountDto>>() {
                });
            }

        } catch (Exception e) {
            System.out.println("Smth Wrong");
        }
        return dtoList;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        if (file.getOriginalFilename() != null) {
            File convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        }
        return null;
    }

    public List<AccountDto> filterByUserName(String username, List<AccountDto> inputAccounts) {
        List<AccountDto> filteredList = new ArrayList<>();
        for (AccountDto account : inputAccounts) {
            if (account.getOwner() != null && account.getOwner().equals(username)) {
                filteredList.add(account);
            }
        }
        return filteredList;
    }

}
