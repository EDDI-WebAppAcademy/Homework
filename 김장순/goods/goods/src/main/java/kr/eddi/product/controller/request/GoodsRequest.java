package kr.eddi.product.controller.request;

import lombok.Getter;


@Getter
public class GoodsRequest {

    private String goodsName;
    private String seller;
    private String goodsDescription;
    private Integer price;
}
