package com.spring.mvcproject.board.repository;

import com.spring.mvcproject.board.entity.Board;
import com.spring.mvcproject.score.entity.Score;

import java.util.List;

public interface BoardRepository {

    // 전체 조회 기능 명세
    List<Board> findAll(String sort);

    // 개별 조회 기능 명세
    Board findOne(Long id);

    // 저장 기능 명세
    void save(Board board);

    // 삭제 기능 명세
    boolean deleteById(Long id);

}
