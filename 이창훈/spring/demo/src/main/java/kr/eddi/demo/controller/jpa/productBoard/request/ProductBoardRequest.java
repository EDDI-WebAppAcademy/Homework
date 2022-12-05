package kr.eddi.demo.controller.jpa.productBoard.request;

import lombok.Getter;

@Getter
public class ProductBoardRequest {
    private String productName;
    private Integer price;
    private String seller;
    private String content;
}
