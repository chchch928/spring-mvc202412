package com.spring.mvcproject.board.api;

import com.spring.mvcproject.board.dto.request.BoardSaveDto;
import com.spring.mvcproject.board.entity.Board;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardApiController {

    private Map<Long, Board> boardStore = new HashMap<>();

    private Long nextId = 1L;

    public BoardApiController() {
        Board b1 = Board.of(nextId++,"안녕하세요","제 이름은 김말복입니다");
        Board b2 = Board.of(nextId++,"오늘 날씨가 춥네요","다들 옷 든든히 입고 다니세요");
        Board b3 =Board.of(nextId++, "요즘 유행하는 신발이 뭔가요??", "신발 사려고 하는데 추천좀요");

        boardStore.put(b1.getId(), b1);
        boardStore.put(b2.getId(), b2);
        boardStore.put(b3.getId(), b3);

    }
    // 게시물 목록조회 GET
    @GetMapping
    public List<Board> boardList() {
        return new ArrayList<>(boardStore.values())
                .stream()
                .sorted(Comparator.comparing(Board::getRegDateTime).reversed())
                .collect(Collectors.toList());
    }


    //게시물 삭제 DELETE
    @DeleteMapping("/{id}")
    public String deleteBoard(
            @PathVariable Long id
    ) {
        boardStore.remove(id);
        return id+ "번 게시물이 삭제되었습니다";
    }

    //게시물 등록 POST
//    @PostMapping
//    public String createBoard(
//            @RequestBody Board board
//    ){
//        board.setId(nextId++);
//        board.setRegDateTime(LocalDateTime.now());
//        System.out.println("board = " + board);
//        boardStore.put(board.getId(), board);
//
//        return "게시물이 생성되었습니다 ";
//
//    }
    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestBody @Valid BoardSaveDto dto
            , BindingResult bindingResult
            ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err ->{
                errorMap.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errorMap);
        }

        Board board = new Board(dto);
        board.setId(nextId++);
        board.setRegDateTime(LocalDateTime.now());

        boardStore.put(board.getId(), board);
        return ResponseEntity.ok().body("게시물 생성 완료"+board);

    }


}
