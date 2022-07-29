package kr.eddi.demo.utility.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.LottoTicket;
import kr.eddi.demo.utility.basic.third.CustomRandom;

//랜덤하면서 중복되지 않는 6개의 로또번호 생성.
public class RandomLottoNum {


    public RandomLottoNum() {

        LottoTicket Lotto1 = new LottoTicket();
        int[] arr = new int[Lotto1.getNUMOFLOTTO()]; //로또 번호 6개

        for (int i = 0; i < arr.length; i++) {
            arr[i] = CustomRandom.makeIntCustomRandom(0, 99); //0~99
            for (int j = 0; j < i; j++) {

                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        Lotto1.setLottoNum(arr); //LottoNum에 6개의 중복되지 않은 숫자 대입.
    }
}