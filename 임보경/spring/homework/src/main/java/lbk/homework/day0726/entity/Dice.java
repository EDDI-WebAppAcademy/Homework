package cls.i.lecture.day0726.entity;

import cls.i.lecture.day0726.utility.RandomNumber;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dice {

    private final int MIN_DICE_NUM = 1;
    private final int MAX_DICE_NUM = 6;

    private final int FIRST_DICE = 1;
    private final int SECOND_DICE = 2;

    private int totalRollDiceNumber;
    private int activePlayer = 1;
    private RandomNumber ranNumb = new RandomNumber();
    private Score score = new Score();

    // 주사위 던지기
    public int rollDice() {
        return ranNumb.makeRandom(MAX_DICE_NUM, MIN_DICE_NUM);
    }

    // [P5 - 우선 단판 게임으로 짜보자.] 주사위 굴릴 횟수 정하기 (엔딩 조건 1)
    public void decideGameNumber() {
        totalRollDiceNumber = rollDice();
    }

    // 첫번째 주사위 굴리기
    public int rollFirstDice() {
        int roll = rollDice();
        int firstResult = 0;

        //짝수 나옴.
        if( roll % 2 == 0 ){
           return firstResult;
        }

        //다음 플레이어에게 진행.
        return firstResult + 1;
    }

    // 두번째 주사위 굴리기
    public void rollSecondDice(int activePlayer) {
        int roll = rollDice();

        switch (roll) {
            case 1 :
                log.info("case 1");
                score.takeScoreAllMember();
            case 3 :
                log.info("case 3");
                score.takeOtherMember(activePlayer);
//            case 4 :
//                return "두번째 주사위까지 진행 : 4나옴 : 해당 플레이어 빠짐.";
//                // 해당 플레이어는 더이상 주사위를 굴릴 수 없다. 이걸 어떻게 멈추지?

            case 5 :
                log.info("case 5");
                score.divideActivePlayerScore(activePlayer);
            default :
                score.divideActivePlayerScore(activePlayer);


        }

    }
}
