package com.pandaserv.dto;

import com.pandaserv.entity.TypeEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TypeDto {

    @NonNull
    private Integer id;

    @NonNull
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDto typeDto = (TypeDto) o;
        return id == typeDto.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int nameValue = type == null ? 0 : type.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }
}
