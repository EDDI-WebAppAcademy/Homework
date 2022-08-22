package kr.eddi.demo.homework.utility.seventh_fix;

import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class LottoNum1 {
    private static final int MIN = 0;  // 로또 번호 최소값
    private static final int MAX = 99;   // 로또 번호 최대값

    private static final int LOTTO_NUMBER_LENGTH = 6;

    public int[] numbers;




    public LottoNum1() {
       // log.info("로또넘버 생성 밎 넘버배열 생성");
        numbers = new int[LOTTO_NUMBER_LENGTH];
    }


    public int runLotto(int numberId) {                           // 로또 번호 1개 추첨하여 저장
        int runNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        numbers[numberId] = runNum;

        return runNum;

    }

}
