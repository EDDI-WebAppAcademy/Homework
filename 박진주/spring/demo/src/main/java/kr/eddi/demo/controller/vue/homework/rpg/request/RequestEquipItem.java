package kr.eddi.demo.controller.vue.homework.rpg.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestEquipItem {
    private ArrayList<Items> equipitemLists;

}

//RequestBuyItem(totalPrice=700000500, itemLists=[Items(atk=100, description=무기 공격력 100, name=낡은 검, price=500), Items(atk=300, description=무기 공격력 300, name=강철 검, price=150000000)])