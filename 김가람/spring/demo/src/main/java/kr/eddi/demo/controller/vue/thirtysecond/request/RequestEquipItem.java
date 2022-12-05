package kr.eddi.demo.controller.vue.thirtysecond.request;

import kr.eddi.demo.entity.vue.thirtiyfirst.UserItems;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
@ToString
public class RequestEquipItem {
    private ArrayList<UserItems> equippedItems;
}
