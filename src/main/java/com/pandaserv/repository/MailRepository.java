package com.pandaserv.repository;

import com.pandaserv.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<MailEntity, Integer> {

    MailEntity findMailEntitiesById(int id);

    MailEntity findMailEntitiesByMail(String mail);

    List<MailEntity> findAll();

    void deleteById(int id);
}
