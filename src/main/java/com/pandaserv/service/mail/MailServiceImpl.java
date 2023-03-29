package com.pandaserv.service.mail;

import com.pandaserv.entity.MailEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.MailRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private MailRepository mailRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public MailEntity create(MailEntity mailEntity) {
        return mailRepository.save(mailEntity);
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
    public MailEntity findMailEntityByMail(String mail) {
        Optional<String> isMail = Optional.ofNullable(mail);
        if (isMail.isPresent()) {
            Optional<MailEntity> isMailEntity = Optional.ofNullable(mailRepository.findMailEntitiesByMail(mail));
            if (!isMailEntity.isPresent()) {
                return mailRepository.save(new MailEntity(mail));
            }
            return isMailEntity.get();
        }
        throw new PandaException("Please give mail", HttpStatus.BAD_REQUEST);
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
