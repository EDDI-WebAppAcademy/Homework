package kr.eddi.demo.utility;

import java.util.Random;

public class RandomNumber {


    /**
     * 최대값을 받아 0 부터 최대값 이하의 랜덤한 정수를 출력한는 메서드
     * @param max 최대값
     * @return
     */
    public static int randomNum(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }

    /**
     * 최소값과 최대값을 받아 범위 내의 랜덤한 정수를 출력하는 메서드
     * @param min 최소값
     * @param max 최대값
     * @return
     */
    public static int randomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }
}
