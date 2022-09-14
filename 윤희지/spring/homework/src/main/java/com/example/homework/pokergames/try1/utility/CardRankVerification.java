package com.example.homework.pokergames.try1.utility;

import java.util.HashMap;

public class CardRankVerification {
    public static HashMap<String, Integer> cardRank = new HashMap<>();

    public static void setCardRank() {
        cardRank.put("HIGH_CARD", 1); // 카드 1장. ace가 제일 높고 2가 제일 낮음
        cardRank.put("ONE_PAIR", 2); // 숫자값 같은 카드 2장
        cardRank.put("TWO_PAIRS", 3); // 페어 2개
        cardRank.put("TRIPS", 4); // 숫자값 같은 카드 3장
        cardRank.put("STRAIGHT", 5); // 무늬 섞인 것 숫자 5개 연속
        cardRank.put("FLUSH", 6); // 같은 무늬 카드 5개
        cardRank.put("FULL_HOUSE", 7); // 트리플 + 원페어
        cardRank.put("FOUR_CARD", 8); // 숫자값 같은 카드 4장
        cardRank.put("STRAIGHT_FLUSH", 9); // 같은 무늬 카드 스트레이트
    }

    public static void checkHighCard() {

    }
}
