package com.pandaserv.repository;

import com.pandaserv.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {

    @Override
    Optional<OwnerEntity> findById(Integer integer);

    Optional<OwnerEntity> findOwnerEntityByOwnerName(String ownerName);

    List<OwnerEntity> findAll();

}
