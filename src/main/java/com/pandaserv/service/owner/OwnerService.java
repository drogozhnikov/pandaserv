package com.pandaserv.service.owner;

import com.pandaserv.entity.OwnerEntity;

import java.util.List;

public interface OwnerService {

    OwnerEntity create(OwnerEntity ownerEntity);

    List<OwnerEntity> readAll();

    OwnerEntity read(int id);

    OwnerEntity findOwnerEntityByOwnerName(String name);

    boolean delete(int id);
}
