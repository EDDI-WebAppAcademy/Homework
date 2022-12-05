package kr.eddi.demo.entity.jpa.products.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String title;
    private String seller;
    private Integer price;
    private String content;
}
