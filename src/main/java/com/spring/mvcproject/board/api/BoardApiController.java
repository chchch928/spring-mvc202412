package com.spring.mvcproject.board.api;

import com.spring.mvcproject.board.dto.request.BoardSaveDto;
import com.spring.mvcproject.board.dto.response.BoardDetailResponse;
import com.spring.mvcproject.board.dto.response.BoardListDto;
import com.spring.mvcproject.board.entity.Board;
import com.spring.mvcproject.board.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardApiController {

    // 컨트롤러는 서비스에게 의존
    private BoardService boardService;

    @Autowired
    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }


    // 게시물 목록조회 GET
//    @GetMapping
//    public List<Board> boardList() {
//        return new ArrayList<>(boardStore.values())
//                .stream()
//                .sorted(Comparator.comparing(Board::getRegDateTime).reversed())
//                .collect(Collectors.toList());
//    }

    @GetMapping
    public ResponseEntity<List<BoardListDto>> boardList(
            @RequestParam(required = false, defaultValue ="id") String sort
    ) {
      List<BoardListDto>responseList = boardService.getList(sort);

      return ResponseEntity.ok().body(responseList);
    }

    // 게시물 상세조회 요청처리
    @GetMapping("/{id}")
    public ResponseEntity<?>detail(@PathVariable Long id) {
        try{
            BoardDetailResponse responseDto = boardService.getDetail(id);

            return ResponseEntity.ok().body(responseDto);
        } catch (IllegalStateException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

    }


    //게시물 삭제 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(
            @PathVariable Long id
    ) {
        try{
        boardService.remove(id);
        return ResponseEntity
                .ok()
                .body("성적정보 삭제 성공 -id: "+id);

        } catch(IllegalStateException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }


    // 게시물 등록 POST
    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestBody @Valid BoardSaveDto dto,
            BindingResult bindingResult
    ) {
        // 입력값 검증 응답 처리
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err -> {
                errorMap.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity
                    .badRequest()
                    .body(errorMap)
                    ;
        }

        Board board = boardService.create(dto);

        return ResponseEntity.ok().body("게시물 등록 성공! - "+ board);

    }



}
