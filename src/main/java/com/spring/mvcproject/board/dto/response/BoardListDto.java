package com.spring.mvcproject.board.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.mvcproject.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BoardListDto {

    private Long bno; // 원본 게시물 번호
    private String shortTitle; // 5글자 이상 줄임 처리된 제목
    private String shortContent; // 15자 이상 줄임 처리된 글 내용
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime date; // 포맷팅된 날짜문자열 (2024/12/20)

    //    private String date; // 포맷팅된 날짜 문자열 (2024/12/20)
    private int view; // 조회수
    private boolean newArticle; // 새 게시물 (1시간 내 인가?)

    public BoardListDto(Board board) {
        this.bno = board.getId();
        this.shortTitle = makeShortTitle(board.getTitle());
        this.shortContent = makeShortContent(board.getContent());
        this.date = board.getRegDateTime();

//        this.date = formatDate(board.getRegDateTime());
        this.view = board.getViewCount();
        this.newArticle = LocalDateTime.now().isBefore ( board.getRegDateTime().plusHours(1));

    }

    private String makeShortTitle(String originTitle) {
        if(originTitle.length() >= 5){
            return originTitle.substring(0, 5)+"...";
        }
        return originTitle;

    }
    private String makeShortContent(String originContent) {
        if(originContent.length() >= 15){
            return originContent.substring(0, 15)+"...";
        }
        return originContent;


    }

//    private String formatDate(LocalDateTime date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//    return date.format(formatter);
//    }

}

