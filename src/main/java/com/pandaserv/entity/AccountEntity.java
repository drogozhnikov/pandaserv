package com.pandaserv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String account;

    private String password;

    private String link;

    private String description;

    @ManyToOne
    @JoinColumn(name = "mail")
    private MailEntity mail;

    @ManyToOne
    @JoinColumn(name = "owner")
    private OwnerEntity owner;

    @ManyToOne
    @JoinColumn(name = "type")
    private TypeEntity type;

    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity location = (AccountEntity) o;
        return id == location.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int passwordValue = password == null ? 0 : password.hashCode() * 31;
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        result = 31 * result + passwordValue + nameValue;
        return result;
    }

}
