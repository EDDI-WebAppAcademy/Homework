package kr.eddi.demo.utility.ten.dicegamebymyself;


public class DiceGame {

    private final int MAX_DICE_NUM = 6;

    private final int ALL_MINUS = 1;
    private final int TAKE_THREE_POINTS = 3;
    private final int GIVE_TWO_POINTS = 5;
    private final int GAME_IS_OVER = 4;

    private int totalScore;

    RollTheDice rollTheDic = new RollTheDice();
    DiceSkills diceSkills = new DiceSkills();


    /**
     * 주사위를 굴려 짝수가 나왔을 경우에만 두번째 주사위를 굴리고, 이외의 경우 첫번째 주사위의 결과만을 리턴합니다
     * @return
     */
    public int firstDice(){
        totalScore = 0;
        int diceResult = rollTheDic.rollingDice(MAX_DICE_NUM);
        totalScore += diceResult;
        if (diceResult % 2 == 0) {
            return secondDice(MAX_DICE_NUM);
        } else {
            return totalScore;
        }
    }


    /**
     * @param MAX_DICE_NUM
     * @return
     */

    public int secondDice(int MAX_DICE_NUM) {
        int diceResult = rollTheDic.rollingDice(MAX_DICE_NUM);
        switch (diceResult) {
            case ALL_MINUS:
                diceSkills.allMinus(diceResult);
                break;
            case TAKE_THREE_POINTS:
                diceSkills.takeThreePoints();
                break;
            case GIVE_TWO_POINTS:
                diceSkills.giveTwoPoints();
                break;
            case GAME_IS_OVER:
                diceSkills.gameIsOver();
                break;
            default:
                break;
        }
        return diceResult;
    }
}

