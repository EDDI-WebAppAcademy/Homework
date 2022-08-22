package questionBank.practice2;

import java.util.ArrayList;

public class Ninth {
//    9. 1 ~ 100까지의 숫자를 순회한다.
//       2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
//      다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
//       그 다음 루프에서 다시 작업을 반복한다.
//      끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?

    private static final int loopStopNum = 5;

    public static void main(String[] args) {
        ArrayList<Integer> loopArr = new ArrayList<>();

        int loopSum = 0;
        int finalLoopSum = 0;
        for (int i = 0; i < loopStopNum; i++) {
            loopArr = Eighth.allMultiple();
            for (int j = 0; j < loopArr.size(); j++) {
                loopSum += loopArr.get(j);
            }
            System.out.println();
            System.out.println("loopSum 합계 : " + loopSum);
            finalLoopSum += loopSum;
            System.out.println("finalLoopSum 합계 : " + finalLoopSum);
            System.out.println();
        }
    }
}
