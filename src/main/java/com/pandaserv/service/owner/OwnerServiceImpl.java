package com.pandaserv.service.owner;

import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void create(OwnerEntity ownerEntity) {
        ownerRepository.save(ownerEntity);
    }

    @Override
    public List<OwnerEntity> readAll() {
        return ownerRepository.findAll();
    }

    @Override
    public OwnerEntity read(int id) {
        return ownerRepository.findOwnerEntitiesById(id);
    }

    @Override
    public boolean update(OwnerEntity ownerEntity, int id) {
        if (ownerRepository.existsById(id)) {
            ownerEntity.setId(id);
            ownerRepository.save(ownerEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
