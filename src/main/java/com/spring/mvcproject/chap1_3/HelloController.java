package com.spring.mvcproject.chap1_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller: 클라이언트의 요청을 받아 로직을 수행하는 역할 (Component의 기능이 탑재)
@Controller // DisptacherServelet이 이 객체를 탐색해서 연결
@RequestMapping("/chap01")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody // JSON 응답
    public String hello() {
        System.out.println("hello spring mvc world");
        return"하위";
    }
    @RequestMapping("/bye")
    @ResponseBody
    public String bye() {
        System.out.println("bye spring mvc world");
        return"바위";
    }
}
