package kr.eddi.homework.entity.nineth;

import kr.eddi.homework.utility.basic.third.CustomRandom;

public class LottoCard {
    private int[] numbers;

    private final int LOTTO_NUMBER_LENGTH = 6;
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS;

    public LottoCard(){
        numbers = new int[LOTTO_NUMBER_LENGTH]; // 총 6개의 숫자 세트
    }

    public int generateLottoNumber(int curIdx){ //인덱스 넘버 받고
        int tmpNum = CustomRandom.makeIntCustomRandom(MIN,MAX); //0~99까지의 랜덤숫자
        numbers[curIdx] = tmpNum; // 랜덤숫자 받은 인덱스에 넣기

        return tmpNum; // 넘버 리턴
    }
}
