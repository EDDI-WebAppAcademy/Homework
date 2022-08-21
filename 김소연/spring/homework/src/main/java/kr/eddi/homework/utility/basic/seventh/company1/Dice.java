package kr.eddi.homework.utility.basic.seventh.company1;

import kr.eddi.homework.entity.seventh.Player;
import kr.eddi.homework.utility.basic.seventh.SpecialDiceOption;
import kr.eddi.homework.utility.basic.third.CustomRandom;

public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    /*
    * 주사위굴리는 메소드
    * @return 주사위값
    * */
    public static int rollDice(){
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }

    public void steelPlayerScore(Player players[], int playerIdx, int steelScore){
        for (int i = 0; i < players.length; i++) {
            if(i == playerIdx){
                continue; //넘어가고
            }
            players[i].getScore().addScore(-steelScore);
            players[playerIdx].getScore().addScore(steelScore);
        }
    }
    public void donatePlayerScore(Player players[], int playerIdx, int donateScore){
        for (int i = 0; i < players.length; i++) {
            if(i == playerIdx) {
                continue;
            }
            players[playerIdx].getScore().addScore(-donateScore);
            players[i].getScore().addScore(donateScore);
        }
    }

    /*
    * 두번째 주사위 특수 기능 관리
    * 숫자 4가 나오는 경우 즉시 게임 오버된다.
    * 숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.
    * 숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.
    * 숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다.
    * */

    /*
    * 플레이어 객체 정보 필요 / 나를 제외하고 적용되는 경우 idx 필요
    * */
    @Override
    public void checkSpecialDice(Player players[], int diceNum, int playerIdx) {
        final int SOB = 1;
        final int LUCKY = 3;
        final int DEATH = 4;
        final int BULLSHIT = 5;

        final int SOB_SCORE = 2;
        final int LUCKY_SCORE = 3;
        final int BULLSHIT_SCORE = -2;
        final int DEATH_SCORE = -444;

        for (int i = 0; i < players.length; i++) {
            switch (diceNum){
                case SOB:
                    players[i].getScore().addScore(-SOB_SCORE);
                    break;
                case LUCKY:
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
