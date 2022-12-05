package com.example.demo.controller.jpa.request.product;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String title;
    private String image;
    private int price;
    private String category;
    private String writer;
    private String content;
}
