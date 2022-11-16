package com.pandaserv.controllers;

import com.pandaserv.entity.TypeEntity;
import com.pandaserv.service.type.TypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    private TypeServiceImpl typeService;

    public TypeController(TypeServiceImpl typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public List<TypeEntity> getAllEvents() {
        return typeService.readAll();
    }

    @GetMapping("/{id}")
    public TypeEntity getAccountById(@PathVariable("id") int id) {
        return typeService.read(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody TypeEntity typeEntity) {
        typeService.create(typeEntity);
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody TypeEntity typeEntity) {
        typeService.update(typeEntity, typeEntity.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        typeService.delete(id);
    }
}
