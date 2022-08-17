package kr.eddi.demo.entity.basic.twelfth;

import lombok.Getter;

@Getter
public class RoundManager {
    private int currentRound;

    public RoundManager() {
        currentRound = 0;
    }

    public void playPokerGame(PlayerManager playerManager) {
        System.out.println("현재 라운드: " + currentRound);
        // 6. 라운드를 시작한다.
        playerManager.playPokerGame(currentRound++);
    }
}
