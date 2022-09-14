package com.example.demo.utillity.basic.poker;

public class BettingMoneyManager {

    private static int totalBetMoney = 0;

    /**
     * 베팅된 금액을 합산하는 메서드 <br>
     * totalBetMoney에 합산
     * @param betMoney
     */
    public static void betMoney(int betMoney) {
        totalBetMoney += betMoney;
    }
}
