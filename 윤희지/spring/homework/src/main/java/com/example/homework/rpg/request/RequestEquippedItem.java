package com.example.homework.rpg.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter

public class RequestEquippedItem {
    ArrayList<Items> equippedItemLists;
}
