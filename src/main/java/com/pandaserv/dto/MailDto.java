package com.pandaserv.dto;

import com.pandaserv.entity.MailEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MailDto {

    @NonNull
    private String mail;

}
