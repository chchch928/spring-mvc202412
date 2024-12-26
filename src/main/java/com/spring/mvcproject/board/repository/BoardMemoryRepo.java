//package com.spring.mvcproject.board.repository;
//
//import com.spring.mvcproject.board.entity.Board;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class BoardMemoryRepo implements BoardRepository {
//
//    private Map<Long, Board> boardStore = new HashMap<>();
//
//    private Long nextId = 1L;
//
//    public BoardMemoryRepo() {
//        Board b1 = Board.of(nextId++,"안녕하세요","제 이름은 김말복입니다");
//        Board b2 = Board.of(nextId++,"오늘 날씨가 춥네요","다들 옷 든든히 입고 다니세요");
//
//        Board b3 =Board.of(nextId++, "요즘 유행하는 신발이 뭔가요??", "신발 사려고 하는데 추천좀요");
//
//        boardStore.put(b1.getId(), b1);
//        boardStore.put(b2.getId(), b2);
//        boardStore.put(b3.getId(), b3);
//
//    }
//
//    @Override
//    public List<Board> findAll(String sort){
//        List<Board> boardList = new ArrayList<>(boardStore.values());
//        return boardList;
//    }
//    @Override
//    public Board findOne(Long id){
//        return boardStore.get(id);
//    }
//    @Override
//    public void save(Board board) {
//        board.setId(nextId++);
//        boardStore.put(board.getId(), board);
//    }
//    @Override
//    public boolean deleteById(Long id){
//        Board removed = boardStore.remove(id);
//        return removed != null;
//    }
//
//
//}
