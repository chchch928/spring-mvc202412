package com.spring.mvcproject.chap2_4.practice;

import com.spring.mvcproject.chap2_4.practice.Book2;
import org.springframework.web.bind.annotation.*;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/books")
public class BookController2 {
    // 데이터베이스 대용으로 책들을 모아서 관리
    private Map<Long,Book2> bookStore = new HashMap<>();

    private long nextId = 1;

    public BookController2() {
        bookStore.put(nextId,new Book2(nextId,"해리포터","JK롤링",15000));
        nextId++;
        bookStore.put(nextId, new Book2(nextId,"반지의제왕","톨킨",13000));
        nextId++;
        bookStore.put(nextId, new Book2(nextId,"트와일라잇","메이어",10000));
        nextId++;
    }

    // 1번 문제. GET요청 : 특정 도서 조회
    @GetMapping("/{id}")
    @ResponseBody
    public String getBook(
            @PathVariable Long id
    ){
        Book2 book = bookStore.get(id);
        if(book == null){
            return "해당 id는 존재 하지 않습니다";
        }
        return ""+ book;
    }

    // 2번 문제. POST 요청: 도서 추가
    @PostMapping
    public String addbook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price
    ){
        Book2 newbook = new Book2(nextId,title,author,price);
        bookStore.put(nextId++, newbook);

        return "새로운 책이 생성되었습니다 -" +newbook.getId();
    }

    // 3번 문제. PUT 요청: 도서 수정
    @PutMapping("/{id}")
    public String updateBook(
            @PathVariable Long id,
            @RequestParam("title") String newtitle,
            @RequestParam("author") String newAuthor,
            @RequestParam("price") int newPrice
    ){
        Book2 foundBook = bookStore.get(id);
        foundBook.setTitle(newtitle);
        foundBook.setAuthor(newAuthor);
        foundBook.setPrice(newPrice);

        return "책의 정보가 수정되었습니다. -" + foundBook;

    }
    // 4번 문제: DELETE 요청: 도서삭제
    @DeleteMapping("/{id}")
    public String deleteBook(
            @PathVariable Long id
    ){
        Book2 deleteBook = bookStore.remove(id);
        if(bookStore.size() == 0){
            return "삭제할 책이 없습니다.";
        }
        return id +"번 책이 삭제되었습니다";
    }
    // 번외
    @GetMapping
    public List<Book2> list(){
        return bookStore.values()
                .stream()
                .collect(Collectors.toList());
    }
}
