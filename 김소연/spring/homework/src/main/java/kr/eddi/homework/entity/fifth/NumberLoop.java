package kr.eddi.homework.entity.fifth;


import kr.eddi.homework.entity.utility.basic.third.CustomRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor

//지정된 숫자 범위
public class NumberLoop {
    private int start;
    private int end;
    private int operationMode;
    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;

    public NumberLoop(int start, int end){
        this.start = start;
        this.end = end;
        this.operationMode = PRINT;
    }

    public String printSimpleFindMatching(int condition){
        String msg = "";

        for (int i = start; i <= end; i++) {
            if(i % condition == 0){
                msg += i + ", ";
            }
        }
        return msg;
    }

    public String printSumFindMatching(int condition){
        int sum = 0;

        for (int i = start; i < end; i++) {
            if(i % condition == 0){
                sum += i;
            }
        }
        return "최종 합산 결과는 " + sum;
    }

    public String printRandomFindMatching(int condition){
        final int MIN = 2;
        final int MAX = 10;

        String msg = "";
        int ranNum = CustomRandom.makeIntCustomRandom(MIN,MAX);

        for (int i = start; i <= end ; i++) {
            if(i % ranNum == 0){
                msg += i +", ";
            }
        }
        return msg;
    }

    public String printSumRefreshRandomFindMatching(int condition){
        final int MIN = 2;
        final int MAX = 10;

        int ranNum;
        int sum = 0;

        ranNum = CustomRandom.makeIntCustomRandom(MIN,MAX);

        for (int i = start; i <= end ; i++) {
            if(i % ranNum == 0){
                ranNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
                sum += i;
            }
        }
        return "최종 합산 결과는 " + sum;
    }

    public String printRefreshRandomMovement(int condition){
        final int MIN = 2;
        final int MAX = 10;

        int ranNum;
        int sum = 0;

        for (int i = start; i <= end; i += ranNum) {
            ranNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
            sum += ranNum;
        }
        return "죄종 합산 결과는 " + sum;
    }

    public String operateWithCondition(int condition){

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
                return printRefreshRandomMovement(condition);

            default:
                System.out.println("잘못된 값을 입력하였습니다!");
                return null;
        }
    }
}
