package com.spring.mvcproject.database.mybatis.dto.response;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Setter @Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetListResponse {

    private int totalCount;
    private List<PetResponse> petList;
}
