package dice.test.fourthExample.tenth;

import java.util.Random;

public class MoveByRandomNumber {
    private static Random random;

    public static void main(String[] args) {
        int MAX_VALUE = 100;
        int endCntValue = 100;
        int referenceNum = 2;
        int totalMoveNum = 0;


        while(true) {
            int multipleNum = randomPickNumber();
            int multipleSum = 0;
            int moveMultipleNum = referenceNum + multipleNum;

            System.out.println("기존의 값 : " + referenceNum + "이고, "
                    + multipleNum + "만큼 이동했습니다.");
            System.out.println("현재 값은: " + moveMultipleNum + "입니다.");

            totalMoveNum += moveMultipleNum;

            for (int i = 1; i <= MAX_VALUE ; i++) {
                if (i % multipleNum == 0) {
                    multipleSum += i;
                }
            }
            System.out.println("==========================");
            System.out.println(moveMultipleNum + "의 배수의 총 합은 : " + multipleSum);
            System.out.println("==========================");
            endCntValue -= 10;

            System.out.println("남은 토큰값 : " + endCntValue);
            System.out.println();

            if (endCntValue <= 0) {
                System.out.println("이동했을 때 나온 숫자들의 합: " + totalMoveNum);
                break;
            }
        }
    }

    public static int randomPickNumber() {
        random = new Random();
        int MAX_RANGE = 10;
        int MIN_RANGE = 2;

        int createMultipleNum = random.nextInt(MAX_RANGE - MIN_RANGE) + MIN_RANGE;
        return createMultipleNum;
    }
}