package kr.eddi.demo.controller.rpgPractice.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}

