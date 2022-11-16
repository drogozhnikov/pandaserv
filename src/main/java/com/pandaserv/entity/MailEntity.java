package com.pandaserv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mails")
public class MailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailEntity mailEntity = (MailEntity) o;
        return id == mailEntity.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int nameValue = mail == null ? 0 : mail.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }

}
