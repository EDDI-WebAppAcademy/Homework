package kr.eddi.demo.entity.fourth;

import kr.eddi.demo.utility.fourth.CustomRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberLoop {
    private int start;
    private int end;
    private int operationMode;
    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;

    public NumberLoop(int start, int end) {
        this.start = start;
        this.end = end;
        this.operationMode = PRINT;
    }

    public String printSimpleFindMatching(int condition) {
        String msg = "";

        for (int i = start; i <= end ; i++) {
            if(i % condition == 0) {
                msg += i + " ";
            }
        }
        return msg;
    }

    public String printSumFindMatching(int condition) {
        String msg = "";
        int sum = 0;
        for (int i = start; i <= end ; i++) {
            if(i % condition == 0) {
                sum += i;
            }
        }
        return condition + "의 배수의 총 합계는 " + sum + " 입니다.";
    }

    public String printRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 10;
        String msg = "";
        int ranNum = CustomRandom.makeCustomRandom(MIN, MAX);
        for (int i = start; i <= end ; i++) {
            if(i % ranNum == 0) {
                msg += i + " ";
            }
        }

        return msg;
    }

    public String operateWithCondition (int condition) {
        switch (operationMode) {
            case PRINT :
                return printSimpleFindMatching(condition);
            case ADD :
                return printSumFindMatching(condition);
            case RANDOM :
                return printRandomFindMatching(condition);
            default :
                System.out.println("잘못 입력하셨습니다.");
                return null;
        }
    }
}
