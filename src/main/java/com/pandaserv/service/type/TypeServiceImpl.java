package com.pandaserv.service.type;

import com.pandaserv.entity.TypeEntity;
import com.pandaserv.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void create(TypeEntity ownerEntity) {
        typeRepository.save(ownerEntity);
    }

    @Override
    public List<TypeEntity> readAll() {
        return typeRepository.findAll();
    }

    @Override
    public TypeEntity read(int id) {
        return typeRepository.findTypeEntitiesById(id);
    }

    @Override
    public boolean update(TypeEntity typeEntity, int id) {
        if (typeRepository.existsById(id)) {
            typeEntity.setId(id);
            typeRepository.save(typeEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (typeRepository.existsById(id)) {
            typeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
