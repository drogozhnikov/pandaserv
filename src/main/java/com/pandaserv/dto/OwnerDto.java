package com.pandaserv.dto;

import com.pandaserv.entity.OwnerEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnerDto {

    @NonNull
    private Integer id;

    @NonNull
    private String ownerName;

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
        int nameValue = ownerName == null ? 0 : ownerName.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }
}
