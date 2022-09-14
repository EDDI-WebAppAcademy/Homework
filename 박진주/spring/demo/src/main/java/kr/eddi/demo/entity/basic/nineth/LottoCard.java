package kr.eddi.demo.entity.basic.nineth;

import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoCard {      // 로또카드 역할 - 로또 낱개 숫자 추첨 + (개인) 6개 로또 숫자 리스트 생성
    private int[] numbers;

    private final int LOTTO_NUMBER_LENGTH = 6;
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS;

    public LottoCard() {
        numbers = new int[LOTTO_NUMBER_LENGTH];
    } // 생성자 - 6개 만큼의 numbers int[6] 배열 생성
                                                                  // -> 즉, 로또 카드 객체가 생성되면 개인의 로또 번호 담을 6자리 배열 numbers 1개가 생성됨.

    public int generateLottoNumber(int curIdx) {                  // 로또 낱개 번호 생성해서 numbers 배열에 값 넣어줌, numbers[0]= 3, numbers[1] =77 ,,,
        int tmpNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        numbers[curIdx] = tmpNum;

        return tmpNum;
    }
}