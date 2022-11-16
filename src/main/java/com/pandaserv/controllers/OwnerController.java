package com.pandaserv.controllers;

import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.service.owner.OwnerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private OwnerServiceImpl ownerService;

    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public List<OwnerEntity> getAllEvents() {
        return ownerService.readAll();
    }

    @GetMapping("/{id}")
    public OwnerEntity getAccountById(@PathVariable("id") int id) {
        return ownerService.read(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody OwnerEntity ownerEntity) {
        ownerService.create(ownerEntity);
    }

    @PutMapping("/")
    public void updateEvent(@RequestBody OwnerEntity ownerEntity) {
        ownerService.update(ownerEntity, ownerEntity.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        ownerService.delete(id);
    }
}
