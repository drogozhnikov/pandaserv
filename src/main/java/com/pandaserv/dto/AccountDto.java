package com.pandaserv.dto;

import lombok.*;

import java.security.acl.Owner;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    private int id;

    private String name;

    private String account;

    private String mail;

    private String owner;

    private String password;

    private String link;

    private String type;

    private String description;

}
