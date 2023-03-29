package com.pandaserv.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnerDto {

    @NonNull
    private String name;

}
