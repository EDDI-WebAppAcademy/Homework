package dice.test.fourthExample.ninth;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;


@Slf4j
public class RandomNumCycle {
    private static Random random;


    public static void main(String[] args) {

        int totalMultipleSum = 0;
        int endCntValue = 10;
        int multipleTitleCnt = 1;
        int MAX_VALUE = 100;
        int totalPickNum = 0;


        while(true) {
            int multipleNum = randomPickNumber();
            int multipleSum = 0;

            System.out.println(multipleTitleCnt + "번째 숫자 : " + multipleNum);
            System.out.print(multipleTitleCnt + "번쨰 숫자 배수 : ");

            for (int i = 1; i <= MAX_VALUE ; i++) {
                if (i % multipleNum == 0) {
                    multipleSum += i;
                    System.out.print(i+", ");
                }
            }
            System.out.println();

            totalMultipleSum += multipleSum;
            totalPickNum += multipleNum;
            System.out.println("==========================");
            System.out.println(multipleTitleCnt+"번째 배수의 총 합: "+ multipleSum);
            System.out.println("==========================");
            multipleTitleCnt++;
            endCntValue -= 1;



            System.out.println("남은 토큰값 : " + endCntValue);
            System.out.println();

            if (endCntValue <= 0) {
                System.out.println("출력된 모든 배수의 총 합: " + totalMultipleSum);
                System.out.println("생성된 모든 숫자들의 총 합 : " + totalPickNum);
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

