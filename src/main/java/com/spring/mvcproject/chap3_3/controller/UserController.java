package com.spring.mvcproject.chap3_3.controller;

import com.spring.mvcproject.chap3_3.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/v3-3/users")
// _ (x) - (o) s붙이는 것이 관례
public class UserController {
    private Map<Long, User>userStore = new HashMap<>();
    private long nextId =1;
    
    // 사용자 생성
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {

        // 검증 // 상태코드로 무엇이 잘못되었는지 알려주어야 함 (ResponseEntity.status)
        if(user.getAge() < 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("cause","bad-age")
                    .body("나이는 양수여야 합니다. age:"+user.getAge());

        }
        if (user.getName().isBlank()){
            return ResponseEntity
                    .status(400)
                    .body("이름은 필수값입니다.");

        }

        user.setId(nextId++);

        System.out.println("user = " + user);
        
        userStore.put(user.getId(), user);
        return ResponseEntity
//              .status(200)
                .ok() // status(200),.status(HttpStatus.OK) 같음
                .body(" \"유저정보가 생성되었습니다 - \" +user");

    }
}
