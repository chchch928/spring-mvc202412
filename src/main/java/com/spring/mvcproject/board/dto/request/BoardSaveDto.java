package com.spring.mvcproject.board.dto.request;

import com.spring.mvcproject.board.entity.Board;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

// DTO에서는 클라이언트의 데이터를 객체 세팅하기 위해
// All 생성자나 Setter를 반드시 구현해놔야 함
// 실무적 측면 - Setter 구현은 불변성을 해칠 수 있으므로 신중하게 선택

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class BoardSaveDto {

    // 필수값 검증
    //NotBlank는 빈문자열 방지
    // NotNull은 null 값만 방지
    // NotEmpty는 둘다 방지

    @NotEmpty(message ="제목은 필수값입니다")
    private String title;

    @NotEmpty(message ="내용은 필수값입니다.")
    private String content;

    // 이 DTO를 데이터 베이스에 저장하기 위해 Entity로 변환하는 메서드
    public Board toEntity(){
        Board b = new Board();
        b.setTitle(this.title);
        b.setContent(this.content);
        b.setViewCount(0);
        b.setRegDateTime(LocalDateTime.now());
        return b;
    }
}
