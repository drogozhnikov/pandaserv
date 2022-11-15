package com.pandaserv.repository;

import com.pandaserv.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {

    TypeEntity findTypeEntitiesById(int id);

    TypeEntity findTypeEntitiesByType(String type);

    List<TypeEntity> findAll();

    void deleteById(int id);
}
