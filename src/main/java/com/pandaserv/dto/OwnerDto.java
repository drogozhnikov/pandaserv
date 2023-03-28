package com.pandaserv.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnerDto {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return id == ownerDto.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }
}
