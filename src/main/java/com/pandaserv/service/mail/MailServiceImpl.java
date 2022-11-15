package com.pandaserv.service.mail;

import com.pandaserv.entity.MailEntity;
import com.pandaserv.repository.MailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    private MailRepository mailRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MailServiceImpl(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public void create(MailEntity mailEntity) {
        mailRepository.save(mailEntity);
    }

    @Override
    public List<MailEntity> readAll() {
        return mailRepository.findAll();
    }

    @Override
    public MailEntity read(int id) {
        return mailRepository.findMailEntitiesById(id);
    }

    @Override
    public boolean update(MailEntity mailEntity, int id) {
        if (mailRepository.existsById(id)) {
            mailEntity.setId(id);
            mailRepository.save(mailEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (mailRepository.existsById(id)) {
            mailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
