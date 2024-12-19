package com.spring.mvcproject.board.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class BoardSaveDto {

    // 필수값 검증
    @NotEmpty(message ="제목은 필수값입니다")
    private String title;

    @NotEmpty(message ="내용은 필수값입니다.")
    private String content;
}
