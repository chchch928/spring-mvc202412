package com.spring.mvcproject.chap2_3.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController1 {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") String productId) {
        return "Product ID: " + productId;
    }
}

