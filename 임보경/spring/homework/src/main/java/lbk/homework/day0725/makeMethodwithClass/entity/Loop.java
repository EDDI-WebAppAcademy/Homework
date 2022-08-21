package lbk.homework.day0725.makeMethodwithClass.entity;

import lbk.homework.day0725.makeMethodwithClass.utility.RandomUtility;

public class Loop {
    private int start;
    private int end;

    //범위를 지정해서 인스턴스 생성
    public Loop(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int bringRandomNumber() {
        int min = 2;
        int max = 10;
        return new RandomUtility().randomNumber(max, min);
    }

    // 해당 문제 [4, 5, 6, 8] 짝수, 3의 배수를 범위 내에서 찾을 수 있는 메서드
    public String findSpecificNumberTimes(int specificNum) {
        String msg = "";
        for (int i = start; i <= end; i++) {
            if (i % specificNum == 0) {
                msg += i + ", ";
            }
        }
        return msg;
    }

    // 해당 문제 [7] 특정 숫자의 배수의 합을 찾기
    public int SumSpecificNumberTimes(int specificNum) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (i % specificNum == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int SumMultiRandomNumber() {
        int sum = 0;
        int specificNum = bringRandomNumber();
        for (int i = start; i <= end; i++) {
            if (i % specificNum == 0) {
                sum += i;
                specificNum = bringRandomNumber();
            }
        }
        return sum;
    }

    public int SumRandomNumber() {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            int specificNum = bringRandomNumber();
            sum += specificNum;

        }
        return sum;
    }


}
