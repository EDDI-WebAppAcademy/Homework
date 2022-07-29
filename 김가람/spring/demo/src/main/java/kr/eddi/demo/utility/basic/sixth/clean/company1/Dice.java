package kr.eddi.demo.utility.basic.sixth.clean.company1;

import kr.eddi.demo.entity.basic.sixth.clean.Player;
import kr.eddi.demo.utility.basic.sixth.clean.SpecialDiceOption;
import kr.eddi.demo.utility.basic.third.CustomRandom;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 메서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 메서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }

    public static void steelPlayerScore(Player players[], int playerIdx, int steelScore) {
        for (int i = 0; i < players.length; i++) {
            if (i == playerIdx) { continue; }

            players[i].getScore().addScore(-steelScore);
            players[playerIdx].getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(Player players[], int playerIdx, int donateScore) {
        for (int i = 0; i < players.length; i++) {
            if (i == playerIdx) { continue; } // 다른 플레이어 점수 줄때 내 점수 뺏기니까 내 순서는 건너뜀.

            players[playerIdx].getScore().addScore(-donateScore);
            players[i].getScore().addScore(donateScore);
        }
    }

    // checkSpecialDice는 플레이어 객체 정보가 필요함.
    // 나를 제외하고 적용하는 경우도 존재하기 때문에
    @Override
    public void checkSpecialDice(Player players[], int diceNum, int playerIdx) {
        final int SOB = 1; // 모두 -2
        final int LUCKY = 3; // 다른 플레이어 -3 / 나 +3
        final int DEATH = 4; // 게임 끝
        final int BULLSHIT = 5; // 나 -2 / 다른 플레이어 +2

        final int SOB_SCORE = -2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444; // 게임 끝으로 임의값 넣어줌.
        final int BULLSHIT_SCORE = -2;

        for (int i = 0; i < players.length; i++) {
            switch (diceNum) {
                case SOB:
                    players[i].getScore().addScore(-SOB_SCORE);
                    break;

                case LUCKY:
                    // 플레이어에 구현하는 것이 좋을까?
                    // 점수에 구현하는 것이 좋을까?
                    // 아니면 별개로 구현하는 것이 좋을까?
                    steelPlayerScore(players, playerIdx, LUCKY_SCORE);
                    break;

                case DEATH:
                    // 게임이 완전히 종료되는 것이 아니라
                    // 한 플레이어의 게임이 끝나는 것
                    players[i].getScore().setTotalScore(DEATH_SCORE);
                    break;

                case BULLSHIT:
                    donatePlayerScore(players, playerIdx, BULLSHIT_SCORE);
                    break;
            }
        }
    }
}
