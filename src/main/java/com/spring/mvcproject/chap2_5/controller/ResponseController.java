package com.spring.mvcproject.chap2_5.controller;

import com.spring.mvcproject.chap2_5.controller.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class ResponseController {

    // 페이지 라우팅 - 특정 뷰(JSP, Thymeleaf)를 포워딩
    @GetMapping("/pet")
    public String pet() {
        return "pet";
    }
    // html 응답
    // 이렇게도 사용할 수 있음을 보여줌 사용X
    @GetMapping("/show/html")
    @ResponseBody // 페이지 라우팅을 하지않고, 순수 리턴데이터를 클라이언트에 전송
    public String html() {
        return """
                <html>
                <body>
                    <h1> HTML 하위</h1>
                </body>
                </html>
                """;
    }
    // 텍스트 응답
    @GetMapping("/show/text")
    @ResponseBody
    public String text() {
        return "하이 나는 문자야";
    }

    // JSON 응답 - 자바의 배열이나 리스트를 리턴하면
    @GetMapping("/json/hobbies")
    @ResponseBody
    public List<String> hobbies(){
        return List.of("수영","농구","낮잠");
    }

    // JSON 객체 응답 - 자바의 Map이나 클래스의 객체를 리턴
    @GetMapping("/json/my-cat")
    @ResponseBody
    public Map<String, Object> myCat(){
        return Map.of(
                "name", "나옹이",
                "age", 3,
                "injection", false

        );
    }
    @GetMapping("/json/my-cat2")
    @ResponseBody
    public Cat myCat2() {
        return new Cat("야옹양옹", 5, true);
    }

    //JSON 객체 배열
    @GetMapping("/json/my-cats")
    @ResponseBody
    public List<Cat> Cats() {
        return List.of(
                new Cat("옥냥이",3,false),
                new Cat("닝냥이",4,true),
                new Cat("꽁냥이",1,true)
        );
    }


}

