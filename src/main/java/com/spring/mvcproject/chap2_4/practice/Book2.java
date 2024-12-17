package com.spring.mvcproject.chap2_4.practice;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Book2 {
    private Long id;
    private String title;
    private String author;
    private int price;

}
