package com.pandaserv.service.mail;

import com.pandaserv.entity.MailEntity;

import java.util.List;

public interface MailService {

    MailEntity create(MailEntity mailEntity);

    List<MailEntity> readAll();

    MailEntity read(int id);

    MailEntity findMailEntityByMail(String mail);

    boolean delete(int id);
}
