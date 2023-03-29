package com.pandaserv.dto;

import lombok.*;

import java.security.acl.Owner;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    @NonNull
    private String name;

    private String account;

    private String mail;

    private String owner;

    @NonNull
    private String password;

    private String link;

    private String type;

    private String description;

}
