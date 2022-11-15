package com.pandaserv.service.mail;

import com.pandaserv.entity.MailEntity;

import java.util.List;

public interface MailService {

    void create(MailEntity mailEntity);

    List<MailEntity> readAll();

    MailEntity read(int id);

    boolean update(MailEntity mailEntity, int id);

    boolean delete(int id);
}
