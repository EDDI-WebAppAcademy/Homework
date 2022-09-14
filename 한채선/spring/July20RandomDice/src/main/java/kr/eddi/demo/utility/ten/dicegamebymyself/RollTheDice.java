package kr.eddi.demo.utility.ten.dicegamebymyself;

import kr.eddi.demo.utility.fourth.CustomRandomNumber;

// 기존에 작성했던 임의의 범위 내의 랜덤한 정수를 출력하는 static 메서드를 재활용
public class RollTheDice {

    private final int MIN_DICE_NUM = 1;

    /**
     * 최대값을 받아 1부터 최대값까지의 눈을 가진 주사위를 굴립니다
     * @param max
     * @return
     */

    public int rollingDice(int max) {
        return CustomRandomNumber.randomNum(MIN_DICE_NUM, max);
    }
}
