package com.spring.mvcproject.board.service;

import com.spring.mvcproject.board.dto.request.BoardSaveDto;
import com.spring.mvcproject.board.dto.response.BoardDetailResponse;
import com.spring.mvcproject.board.dto.response.BoardListDto;
import com.spring.mvcproject.board.entity.Board;
import com.spring.mvcproject.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardListDto> getList(String sort){
        List<BoardListDto>responseData = boardRepository.findAll(sort)
                .stream()
                .map(board -> new BoardListDto(board))
                .collect(Collectors.toList());

        return responseData;
    }
    // 성적 단일 조회 핵심 비즈로직 처리
    public BoardDetailResponse getDetail(Long id){
        Board targetBoard = boardRepository.findOne(id);

        // 예외처리
        if(targetBoard == null){
            throw new IllegalStateException(id + " not found");
        }
        //----------틀린부분---------------//
        // BoardDetailResponse에서 from을 이용해서 만들었기때문에
        // BoardDetailResponse.from(targetBoard)를 사용해서 데이터를 불러 와야함
        BoardDetailResponse responseDto =  BoardDetailResponse.from(targetBoard);
        return responseDto;

    }
    public Board create(BoardSaveDto dto){
        Board board = dto.toEntity();
        boardRepository.save(board);
        return board;

    }
    public void remove(Long id){
        boolean removed = boardRepository.deleteById(id);
        if(!removed){
            throw new IllegalStateException(id + " not found");
        }
    }

}
