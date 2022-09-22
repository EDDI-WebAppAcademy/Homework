package kr.eddi.demo.entity.jpa.goodsSaleBoards.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String title;
    private String seller;
    private String price;
    private String content;
}
