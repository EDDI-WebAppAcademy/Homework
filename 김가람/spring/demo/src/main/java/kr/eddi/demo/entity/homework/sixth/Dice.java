package kr.eddi.demo.entity.homework.sixth;

import kr.eddi.demo.utility.basic.third.CustomRandom;

public class Dice {
    private final int MIN = 1;
    private final int MAX = 6;
    private int diceNum;
    Score score;

    public int diceRoll() {
        diceNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        return diceNum;
    }

    public void firstDiceRoll() {
        score = new Score();

        diceNum = diceRoll();
        if(diceNum % 2 == 0) {
            // 스코어에 점수가 들어가는 기능 필요
            secondDiceRoll();
        } else {
            // 스코어에 점수가 들어가는 기능 필요

        }
    }

    public void secondDiceRoll() {
        score = new Score();

        diceNum = diceRoll();
        switch (diceNum) {
            case 1:
                //모두 다 -2점
                break;
            case 3:
                //친구들 주사위 -3점 / 내 주사위 +3점
                break;
            case 4:
                //게임오버
                break;
            case 5:
                //내주사위 -2점 / 친구들 주사위 +2점
                break;
            default:
                // 스코어에 점수가 들어가는 기능 필요
                break;
        }
    }
}
