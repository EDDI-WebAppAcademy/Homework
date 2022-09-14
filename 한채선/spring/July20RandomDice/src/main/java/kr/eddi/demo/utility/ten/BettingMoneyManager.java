package kr.eddi.demo.utility.ten;

public class BettingMoneyManager {

    private static int totalBetMoney;

    public static void betMoney(int betMoney, int playerNum) {
        totalBetMoney += (betMoney * playerNum);
    }
}
