package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public class RoundManager {

    private int currentRound;

    public RoundManager() {   // 라운드매니저 생성될 때 current round =0 으로 세팅
        currentRound = 0;
    }

    public void playPockerGame(PlayerManager playerManager) {          //  콘솔 출력되는 내용 1 (현재 라운드)
        System.out.println("현재 라운드: " + currentRound);
        // 6. 라운드를 시작한다.
        playerManager.playPockerGame(currentRound++);             //인자에서 playerManager 받아서 playerPokerGame(현재라운드 증가) 시작 -> 플레이어매니저 메소드 확인
    }
}