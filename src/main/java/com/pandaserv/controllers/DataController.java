package com.pandaserv.controllers;

import com.pandaserv.dto.MailDto;
import com.pandaserv.dto.OwnerDto;
import com.pandaserv.model.Type;
import com.pandaserv.service.AccountService;
import com.pandaserv.service.DataService;
import com.pandaserv.service.MailService;
import com.pandaserv.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin //needed to Vue
@RequestMapping("/api/panda/data")
@AllArgsConstructor
public class DataController {

    private MailService mailService;
    private OwnerService ownerService;
    private DataService dataService;
    private AccountService accountService;

    @GetMapping("/mails")
    public List<MailDto> getMails() {
        return mailService.readAll();
    }

    @GetMapping("/owners")
    public List<OwnerDto> getOwners() {
        return ownerService.readAll();
    }

    @GetMapping("/types")
    public List<Type> getTypes() {
        return Arrays.stream(Type.values()).collect(Collectors.toList());
    }

    @GetMapping("/passgen")
    public String generatePassword() {
        return dataService.generatePassword();
    }

    @PostMapping("/loadJson")
    public void loadJson(@RequestParam String username, @RequestPart MultipartFile file) {
        accountService.loadJson(username, dataService.readJson(file));
    }

    @PostMapping("/loadAndReplaceJson")
    public void loadAndReplaceJson(@RequestParam String username, @RequestPart MultipartFile file) {
        accountService.loadAndReplaceJson(username, dataService.readJson(file));
    }

    @GetMapping("/template")
    public ResponseEntity<Object> downloadTemplate() throws IOException {
        File file = dataService.getTemplateFile();
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

}
