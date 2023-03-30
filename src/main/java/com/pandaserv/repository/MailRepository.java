package com.pandaserv.repository;

import com.pandaserv.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MailRepository extends JpaRepository<MailEntity, Integer> {

    Optional<MailEntity> findMailEntityByMail(String mail);

    List<MailEntity> findAll();

}
