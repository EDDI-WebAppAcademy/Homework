package kr.eddi.demo.utility.basic.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.List;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 메서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 메서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }

    public static void steelPlayerScore(List<Player> players, int playerIdx, int steelScore) {
        for (int i = 0; i < players.size(); i++) {
            if (i == playerIdx) { continue; }

            players.get(i).getScore().addScore(-steelScore);
            players.get(playerIdx).getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(List<Player> players, int playerIdx, int donateScore) {
        for (int i = 0; i < players.size(); i++) {
            if (i == playerIdx) { continue; } // 다른 플레이어 점수 줄때 내 점수 뺏기니까 내 순서는 건너뜀.

            players.get(playerIdx).getScore().addScore(-donateScore);
            players.get(i).getScore().addScore(donateScore);
        }
    }

    // checkSpecialDice는 플레이어 객체 정보가 필요함.
    // 나를 제외하고 적용하는 경우도 존재하기 때문에
    @Override
    public void checkSpecialDice(List<Player> players, int diceNum, int playerIdx) {
        final int SOB = 1; // 모두 -2
        final int LUCKY = 3; // 다른 플레이어 -3 / 나 +3
        final int DEATH = 4; // 게임 끝
        final int BULLSHIT = 5; // 나 -2 / 다른 플레이어 +2

        final int SOB_SCORE = -2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444; // 게임 끝으로 임의값 넣어줌.
        final int BULLSHIT_SCORE = -2;

        for (int i = 0; i < players.size(); i++) {
            switch (diceNum) {
                case SOB:
                    players.get(i).getScore().addScore(-SOB_SCORE);
                    break;

                case LUCKY:
                    // 플레이어에 구현하는 것이 좋을까?
                    // 점수에 구현하는 것이 좋을까?
                    // 아니면 별개로 구현하는 것이 좋을까?
                    steelPlayerScore(players, playerIdx, LUCKY_SCORE);
                    i++;
                    // steelPlayerScore메서드 안에 for문이 존재함. 그 for문에서 player1, 2 모두에게 적용됨. 여기서 i++하여 멈추지 않으면 for문이 한번 더 진행됨.
                    break;

                case DEATH:
                    // 게임이 완전히 종료되는 것이 아니라
                    //players.get(i).getScore().setTotalScore(DEATH_SCORE);
                    // 한 플레이어의 게임이 끝나는 것 -> 즉 players.get(playerIdx)가 되어야함!
                    players.get(playerIdx).getScore().setTotalScore(DEATH_SCORE);
                    // DEATH_SCORE는 addScore메서드 처리하지 않음. addScore로 처리하면 total은 음수기 때문에 0으로 지정되기때문.
                    i++;
                    // steelPlayerScore메서드 안에 for문이 존재함. 그 for문에서 player1, 2 모두에게 적용됨. 여기서 i++하여 멈추지 않으면 for문이 한번 더 진행됨.
                    break;

                case BULLSHIT:
                    donatePlayerScore(players, playerIdx, BULLSHIT_SCORE);
                    break;
            }
        }
    }
}
