package com.example.demo.entity.basic.lotto.poker;

import lombok.Getter;

@Getter
public class RoundManager {

    private int currentRound;

    public RoundManager() {
        currentRound = 0;
    }

    /**
     * 플레이매니저 - 플레이포커게임 메서드에 현재 라운드를 알려주는 메서드
     * @param playerManager
     */
    public void playpokerGame(PlayerManager playerManager) {
        System.out.println("현재 라운드: " + currentRound);
        // 6. 라운드를 시작한다.
        playerManager.playpokerGame(currentRound++);
    }
}
