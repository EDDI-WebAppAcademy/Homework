package com.example.homework.pokergames.try2.utility;

public class BettingMoneyManager {
    private static int totalBetMoney = 0;

    // 3. 초기 베팅 머니를 부과한다.
    // 굳이 따지자면 판돈 저장소..그런 느낌?

    //라운드 마다 배팅을 해야되는데 베팅 금액이 올라간드앙...이거는 어디서 관리?
    // 이건 구현하지 말자^^
    public static void betMoney(int betMoney) {
        totalBetMoney += betMoney;
    }
}