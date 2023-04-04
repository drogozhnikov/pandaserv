package com.pandaserv.entity;

import com.pandaserv.model.Type;
import lombok.*;

import javax.persistence.*;

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

    @NonNull
    private String name;

    private String account;

    @NonNull
    private String password;

    private String link;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "mail")
    private MailEntity mail;

    @ManyToOne
    @JoinColumn(name = "owner")
    private OwnerEntity owner;

}
