package com.spring.mvcproject.chap2_3.controller;

import com.spring.mvcproject.chap2_3.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    // 가상의 메모리 상품 저장소
    private Map<Long, Product> productStore = new HashMap<>();

    public ProductController() {
        productStore.put(1L, new Product(1L, "에어컨", 1000000));
        productStore.put(2L, new Product(2L, "세탁기", 1500000));
        productStore.put(3L, new Product(3L, "공기청정기", 200000));
    }


    // 예전 방식
    // 특정 상품 조회: GET
//    @GetMapping("/products")
//    public String getProducts(HttpServletRequest req) {
//        String id =  req.getParameter("id");
//        String price = req.getParameter("price");
//
//        System.out.println("/products?id=%s : GET 요청이 들어옴".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    //products?id=8&price=12000
//   @GetMapping("/products")
//    public String getProduct(
//            Long id,
//            int price
//    ) {
//        System.out.println("/products?id=%s : GET 요청이 들어옴".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    //products?id=8 (price를 입력하지 않았을 경우) -> 에러발생
    // 옵션 줄때는 requestParam 생략하면 안됨
//    @GetMapping("/products")
//    public String getProduct(
//            Long id,
//            @RequestParam(required = false,defaultValue = "1000") int price
//    ) {
//        System.out.println("/products?id=%s : GET 요청이 들어옴".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

        @GetMapping("/products/{id}")
        @ResponseBody
    public Product getProduct(
            @PathVariable Long id
    ) {
        System.out.println("/products/%s : GET 요청이 들어옴".formatted(id));
        System.out.println("id = " + id);

        Product product = productStore.get(id);
        return product;
    }



}
