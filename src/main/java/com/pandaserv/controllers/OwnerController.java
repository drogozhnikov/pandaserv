package com.pandaserv.controllers;

import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.service.owner.OwnerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {

    private OwnerServiceImpl ownerService;

    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners/all")
    public List<OwnerEntity> getAllEvents() {
        return ownerService.readAll();
    }

    @GetMapping("/owners/{id}")
    public OwnerEntity getAccountById(@PathVariable("id") int id) {
        return ownerService.read(id);
    }

    @PostMapping("/owners")
    public void createAccount(@RequestBody OwnerEntity ownerEntity) {
        ownerService.create(ownerEntity);
    }

    @PutMapping("/owners/")
    public void updateEvent(@RequestBody OwnerEntity ownerEntity) {
        ownerService.update(ownerEntity, ownerEntity.getId());
    }

    @DeleteMapping("/owners/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        ownerService.delete(id);
    }
}
