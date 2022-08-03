package kr.eddi.demo.homeworkEntity.utility.basic.seventh;

import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import kr.eddi.demo.homeworkEntity.seventh.LottoPlayer;

import java.util.List;


public class LottoNum { //implements PreventLottoSameNumOption
    private static final int MIN = 0;  // 로또 번호 최소값
    private static final int MAX = 99;   // 로또 번호 최대값


    public static int runLotto() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }


}