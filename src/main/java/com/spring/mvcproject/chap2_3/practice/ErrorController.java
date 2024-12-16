package com.spring.mvcproject.chap2_3.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ErrorController {

    @GetMapping("/info/{userId}")
    public String getInfo(@PathVariable("userId") String userId) {
        return "User Info: " + userId;
    }
}


