package com.example.product.controller.jpa.productBoard.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String productName;
    private String seller;
    private String productDescription;
    private Integer price;
}
