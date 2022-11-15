package com.pandaserv.controllers;

import com.pandaserv.entity.TypeEntity;
import com.pandaserv.service.type.TypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeController {

    private TypeServiceImpl typeService;

    public TypeController(TypeServiceImpl typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types/all")
    public List<TypeEntity> getAllEvents() {
        return typeService.readAll();
    }

    @GetMapping("/types/{id}")
    public TypeEntity getAccountById(@PathVariable("id") int id) {
        return typeService.read(id);
    }

    @PostMapping("/types")
    public void createAccount(@RequestBody TypeEntity typeEntity) {
        typeService.create(typeEntity);
    }

    @PutMapping("/types/")
    public void updateEvent(@RequestBody TypeEntity typeEntity) {
        typeService.update(typeEntity, typeEntity.getId());
    }

    @DeleteMapping("/types/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        typeService.delete(id);
    }
}
