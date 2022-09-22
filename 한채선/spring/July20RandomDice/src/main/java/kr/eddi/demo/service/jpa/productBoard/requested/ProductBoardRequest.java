package kr.eddi.demo.service.jpa.productBoard.requested;

import lombok.Getter;

@Getter
public class ProductBoardRequest {

    private String productName;
    private Long price;
    private String content;
}
