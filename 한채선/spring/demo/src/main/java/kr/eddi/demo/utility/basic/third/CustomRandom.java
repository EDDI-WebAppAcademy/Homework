package kr.eddi.demo.utility.basic.third;

import java.util.Random;

public class CustomRandom {


    /**
     * 최소값과 최대값을 받아 랜덤한 정수를 생성하는 메서드
     * @param min 최소값
     * @param max 최대값
     * @return 최소값과 최대값 사이의 랜덤한 정수
     */
    public static int makeIntCustomRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
