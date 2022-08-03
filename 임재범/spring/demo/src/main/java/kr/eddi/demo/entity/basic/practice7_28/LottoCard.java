package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;



@Getter
@ToString
public class LottoCard {
    private int[] numbers; //로또 번호가 저장되는 공간.

    private final int LOTTO_NUMBER_LENGTH = 6;//로또번호 갯수
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS; //CustomRandom 유틸리티 클래스로 0~99사이의 수를 생성하기 위함.

    //LottoCard객체 생성시 numbers라는 int형 배열은 6칸의 공간이 생깁니다.
    public LottoCard() {
        numbers = new int[LOTTO_NUMBER_LENGTH];
    }

    //이 메서드는 number라는 6칸짜리 배열에 0~99사이의 숫자를 대입하는 역할입니다. curIdx는 배열의 몇번쨰 요소에 저장할지 지정합니다.
    public int generateLottoNumber(int curIdx) {
        int tmpNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        numbers[curIdx] = tmpNum;

        return tmpNum;
    }
}
