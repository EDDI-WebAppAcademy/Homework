package com.example.homework.pokergames.try2.entity;

import com.example.homework.pokergames.try2.utility.BettingMoneyManager;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class PokerGameManager {
    private PlayerManager playerManager;
    private RoundManager roundManager;

    private final int DEFAULT_BETTING_MONEY = 1000000;

    public PokerGameManager(int playerNum) {
        playerManager = new PlayerManager(playerNum);
        roundManager = new RoundManager();

    }

    public void startGame() {
        // 3. 초기 베팅 머니를 부과한다.
        BettingMoneyManager.betMoney(DEFAULT_BETTING_MONEY * playerManager.getPlayerNum());

        do {
            roundManager.playGame(playerManager);
        } while (isGameFinish());
    }

    public boolean isGameFinish() {
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        System.out.print("한판 더?");
        if(response.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    // 11. 최종 승자 판정
    //public Player dicisionWinner() {
    //    return
    //}

}
