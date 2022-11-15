package com.pandaserv.service.type;

import com.pandaserv.entity.TypeEntity;

import java.util.List;

public interface TypeService {

    void create(TypeEntity typeEntity);

    List<TypeEntity> readAll();

    TypeEntity read(int id);

    boolean update(TypeEntity typeEntity, int id);

    boolean delete(int id);
}
