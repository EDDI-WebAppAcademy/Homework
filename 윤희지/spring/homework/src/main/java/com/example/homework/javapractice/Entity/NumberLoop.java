package com.example.homework.javapractice.Entity;

import com.example.homework.utility.CustomRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberLoop {
    private int start;
    private int end;
    private int operationMode;

    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;

    //NumberLoop 생성자. start, end를 입력한다. operationMode는 PRINT로 기본설정.
    public NumberLoop(int start, int end) {
        this.start = start;
        this.end = end;
        this.operationMode = PRINT;
    }

    public String operateWithCondition(int condition) {
        switch (operationMode) {
            case PRINT:
                return printSimpleFindMatching(condition);

            case ADD:
                return printSumFindMatching(condition);

            case RANDOM:
                return printRandomFindMatching(condition);

            case REFRESH_RANDOM_SUM:
                return printSumRefreshRandomFindMatching(condition);

            case REFRESH_RANDOM_MOVEMENT:
                return printSumRefreshRandomMovement(condition);

            default:
                System.out.println("잘못된 값을 입력하였습니다.");
                return null;
        }
    }

    private String printSimpleFindMatching(int condition) {
        String msg = "";

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    private String printSumFindMatching(int condition) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum + "입니다.";
    }

    private String printRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 9;

        String msg = "";
        int ranNum;

        ranNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % ranNum == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    private String printSumRefreshRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 9;

        int ranNum;
        int sum = 0;

        ranNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % ranNum == 0) {
                ranNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum + "입니다.";
    }

    private String printSumRefreshRandomMovement(int condition) {
        final int MIN = 2;
        final int MAX = 9;

        int ranNum;
        int sum = 0;

        for (int i = start; i <= end; i += ranNum) {
            ranNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
            sum += i + ranNum;
        }

        return "최종 합산 결과는 " + sum + "입니다.";
    }
}