package com.pandaserv.repository;

import com.pandaserv.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {

    OwnerEntity findOwnerEntitiesById(int id);

    OwnerEntity findOwnerEntitiesByOwnerName(String ownerName);

    List<OwnerEntity> findAll();

    void deleteById(int id);
}
