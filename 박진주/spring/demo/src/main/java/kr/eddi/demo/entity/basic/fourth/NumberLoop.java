package kr.eddi.demo.entity.basic.fourth;


import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
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

    //생성자
    public NumberLoop(int start, int end) { // 생성자에서 인자(operationMode)를 생략해도 나중에 넣을 수 있는지?
        this.start = start;
        this.end = end;
        this.operationMode = PRINT;        // 기본값은 출력
    }

    public String printSimpleFindMatching(int condition) {
        String msg = "";  // 스트링 초기값 지정

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                msg += i + ", ";         // 결과 출력 시 콤마로 이어주기 위해서 String형 사용.  출력 예시) 2, 4, 6 ..
            }
        }

        return msg;
    }

    public String printSumFindMatching(int condition) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum;
    }

    public String printRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        String msg = "";
        int randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % randNum == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    public String printSumRefreshRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        //String msg = "";
        int randNum;
        int sum = 0;

        // 7의 배수가 나왔음
        // 그 다음 루프에서 9의 배수
        randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % randNum == 0) {
                randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum;
    }

    public String printRefreshRandomMovement(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        int randNum;
        int sum = 0;

        for (int i = start; i <= end; i += randNum) {
            randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
            sum += randNum;
        }

        return "최종 합산 결과는 " + sum;
    }

    public String operateWithCondition (int condition) {

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
