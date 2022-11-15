package com.pandaserv.service.owner;

import com.pandaserv.entity.OwnerEntity;

import java.util.List;

public interface OwnerService {

    void create(OwnerEntity ownerEntity);

    List<OwnerEntity> readAll();

    OwnerEntity read(int id);

    boolean update(OwnerEntity ownerEntity, int id);

    boolean delete(int id);
}
