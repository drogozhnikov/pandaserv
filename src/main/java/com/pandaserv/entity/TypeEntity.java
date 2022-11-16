package com.pandaserv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntity typeEntity = (TypeEntity) o;
        return id == typeEntity.id;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        int nameValue = type == null ? 0 : type.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }
}
