package com.pandaserv.dto;

import com.pandaserv.entity.MailEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MailDto {

    @NonNull
    private Integer id;

    @NonNull
    private String mail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailDto mailDto = (MailDto) o;
        return id == mailDto.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int nameValue = mail == null ? 0 : mail.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }
}
