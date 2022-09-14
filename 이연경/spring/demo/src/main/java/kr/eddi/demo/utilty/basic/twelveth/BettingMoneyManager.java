package kr.eddi.demo.utilty.basic.twelveth;

public class BettingMoneyManager {

    private static int totalBetMoney = 0;

    public static void betMoney(int betMoney) {
        totalBetMoney += betMoney;
    }
}
