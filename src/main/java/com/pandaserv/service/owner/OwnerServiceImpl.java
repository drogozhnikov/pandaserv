package com.pandaserv.service.owner;

import com.pandaserv.entity.MailEntity;
import com.pandaserv.entity.OwnerEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public OwnerEntity create(OwnerEntity ownerEntity) {
        return ownerRepository.save(ownerEntity);
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
    public OwnerEntity findOwnerEntityByOwnerName(String name) {
        Optional<String> isOwner = Optional.ofNullable(name);
        if (isOwner.isPresent()) {
            Optional<OwnerEntity> isOwnerEntity = Optional.ofNullable(ownerRepository.findOwnerEntityByOwnerName(name));
            if (!isOwnerEntity.isPresent()) {
                return ownerRepository.save(new OwnerEntity(name));
            }
            return isOwnerEntity.get();
        }
        throw new PandaException("Please give owner", HttpStatus.BAD_REQUEST);
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
