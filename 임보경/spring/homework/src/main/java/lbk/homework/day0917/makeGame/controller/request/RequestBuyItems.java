package lbk.homework.day0917.makeGame.controller.request;

import lbk.homework.day0917.makeGame.entity.item.ShopItem;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RequestBuyItems {

    List<ShopItem> shoppingCart;


}
