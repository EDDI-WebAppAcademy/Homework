package kr.eddi.demo.entity.basic.utility.basic.sixth2_clean.company1;

import kr.eddi.demo.entity.basic.sixth2_clean.Player;
import kr.eddi.demo.entity.basic.utility.basic.sixth2_clean.SpecialDiceOption;
import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 매서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 매서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {      //  SpecialDiceOption 인터페이스의 checkSpecialDice() 메소드 틀 가져옴
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }  // 단순 주사위 기능

    //checkSpecialDice 사용용 메소드1
    public static void steelPlayerScore(Player players[], int playerIdx, int steelScore) {   // 주사위 점수 뺏기
        for (int i = 0; i < players.length; i++) {                      //여기서 players.length가 별도의 임포트 없이 가능한 이유는 파라미터에 players 받기 때문
            if (i == playerIdx) { continue; }                           // i와 PlayerIdx 가 동일하다면 = 본인이면 건너뛰어라
                                                                        // 여기서 for문을 쓰는 이유도 전체 참가자 적용이기 때문.
            players[i].getScore().addScore(-steelScore);
            players[playerIdx].getScore().addScore(steelScore);
        }
    }

    //checkSpecialDice 사용용 메소드2
    public static void donatePlayerScore(Player players[], int playerIdx, int donateScore) {   // 주사위 점수 주기
        for (int i = 0; i < players.length; i++) {
            if (i == playerIdx) { continue; }

            players[playerIdx].getScore().addScore(-donateScore);
            players[i].getScore().addScore(donateScore);
        }
    }

    // checkSpecialDice는 플레이어 객체 정보가 필요함
    // 나를 제외하고 적용하는 경우도 존재하니까
    @Override
    public void checkSpecialDice(Player players[], int diceNum, int playerIdx) {  // 전체 참가자들에게 규칙에 따라 점수 배분하는 메소드
        final int SOB = 1;
        final int LUCKY = 3;
        final int DEATH = 4;
        final int BULLSHIT = 5;

        final int SOB_SCORE = 2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444;
        final int BULLSHIT_SCORE = 2;

        for (int i = 0; i < players.length; i++) {         //어차피 player 개별에 대해 돌아가는 메소드일텐데 여기서 for문은 왜 하는 걸까?
                                                         //-> 해당 메소드는 전체 플레이어에게 점수를 배분하는 형태이므로 본인을 제외한 0,1,2,.. 참가자들에게 적용하는 옵션이므로
            switch (diceNum) {
                case SOB:
                    players[i].getScore().addScore(-SOB_SCORE);
                    break;

                case LUCKY:
                    // 플레이어에 구현하는 것이 좋을까 ?
                    // 점수에 구현하는 것이 좋을까 ?
                    // 아니면 별개로 구현하는 것이 좋을까 ?
                    steelPlayerScore(players, playerIdx, LUCKY_SCORE);
                    break;

                case DEATH:
                    players[i].getScore().setTotalScore(DEATH_SCORE);
                    break;

                case BULLSHIT:
                    donatePlayerScore(players, playerIdx, BULLSHIT_SCORE);
                    break;
            }
        }
    }
}