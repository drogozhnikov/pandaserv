package com.pandaserv.service;

import com.pandaserv.dto.MailDto;
import com.pandaserv.entity.MailEntity;
import com.pandaserv.exception.PandaException;
import com.pandaserv.repository.MailRepository;
import com.pandaserv.service.converter.MailConverter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MailService {

    private MailRepository mailRepository;
    private MailConverter mailConverter;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void create(MailEntity mailEntity) {
        mailRepository.save(mailEntity);
    }

    public List<MailDto> readAll() {
        return mailConverter.convertAllToDto(mailRepository.findAll());
    }

    public MailEntity findOrSaveAndGetMail(String mail) {
        if (Optional.ofNullable(mail).isPresent()) {
            return mailRepository.findMailEntityByMail(mail).orElseGet(() -> mailRepository.save(new MailEntity(mail)));
        }
        throw new PandaException("Please give mail", HttpStatus.BAD_REQUEST);
    }

    public void delete(MailDto mailDto) {
        if (Optional.ofNullable(mailDto).isPresent()) {
            Optional<MailEntity> entity = mailRepository.findMailEntityByMail(mailDto.getMail());
            entity.ifPresent(mailEntity -> mailRepository.delete(mailEntity));
        }
    }
}
