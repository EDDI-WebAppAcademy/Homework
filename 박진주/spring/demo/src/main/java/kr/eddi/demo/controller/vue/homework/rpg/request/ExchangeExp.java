package kr.eddi.demo.controller.vue.homework.rpg.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
@Setter
public class ExchangeExp {
    private ArrayList<String> exchangeExpLists;

    private final int HP = 0;
    private final int MP = 1;
    private final int ATK = 2;
    private final int STR = 3;
    private final int DEX = 4;
    private final int INT = 5;
    private final int DEF = 6;
    private final int HP_MP_INCREMENT = 50;
    private final int OTHER_STATS_INCREMENT = 5;
    private final int EXCHANGE_EXP_POINT = 1000;

    private int exchangeHP = 0;
    private int exchangeMP = 0;
    private int exchangeATK = 0;
    private int exchangeSTR = 0;
    private int exchangeDEX = 0;
    private int exchangeINT = 0;
    private int exchangeDEF = 0;
}
