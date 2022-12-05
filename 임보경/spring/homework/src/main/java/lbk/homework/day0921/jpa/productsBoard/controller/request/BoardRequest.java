package lbk.homework.day0921.jpa.productsBoard.controller.request;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardRequest {

    private String productName;
    private Long price;
    private String details;
    private Long numberInStock;
}
