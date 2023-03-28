package com.pandaserv.dto;

import lombok.*;

import java.security.acl.Owner;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    private String account;

    private MailDto mail;

    private OwnerDto owner;

    @NonNull
    private String password;

    private String link;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto accountDto = (AccountDto) o;
        return id == accountDto.id;
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
