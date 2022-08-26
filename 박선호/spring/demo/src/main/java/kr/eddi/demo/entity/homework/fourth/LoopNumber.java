package kr.eddi.demo.entity.homework.fourth;

import kr.eddi.demo.utility.basic.third.CustomRandom;

public class LoopNumber {

    private int start;
    private int end;
    private int operateMode;

    public LoopNumber(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String printMultipleOfNumber(int num) {
        String msg = "";

        for (int i = start; i <= end; i++) {
            if (i % num == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    public String printSumMultipleOfNumber(int num) {
        String msg = "";
        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (i % num == 0) {
                sum += i;
            }
        }

        return num + "의 배수 합산 결과: " + sum;
    }

    public String printMultipleOfRandomNumber(int min, int max) {
        String msg = "";
        int randomNum = CustomRandom.makeIntCustomRandom(min, max);

        for (int i = start; i <= end; i++) {
            if (i % randomNum == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    public String printSumRefreshMultipleOfRandomNumber(int min, int max) {
        String msg = "";
        int randomNum;
        int sum = 0;

        randomNum = CustomRandom.makeIntCustomRandom(min, max);

        for (int i = start; i <= end; i++) {
            if (i % randomNum == 0) {
                randomNum = CustomRandom.makeIntCustomRandom(min, max);
                sum += i;
            }
        }

        return "랜덤 배수들의 합산 결과: " + sum;
    }

    public String printRefreshRandomMovement(int min, int max) {
        int randomNum;
        int sum = 0;

        for (int i = start; i <= end; i += randomNum) {
            randomNum = CustomRandom.makeIntCustomRandom(min, max);
            sum += randomNum;
        }

        return "총 이동 숫자 합산 결과: " + sum;
    }
}
