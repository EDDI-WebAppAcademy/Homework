package kr.eddi.demo.controller.jpa.productBoard.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String name;
    private Integer price;
    private Integer stock;
    private String description;
}
