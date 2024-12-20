package com.spring.mvcproject.board.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.mvcproject.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class BoardDetailDto {

    private Long bno;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime date;

public BoardDetailDto(Board b){
    this.bno = b.getId();
    this.title = b.getTitle();
    this.content = b.getContent();
    this.date = b.getRegDateTime();

}
}
