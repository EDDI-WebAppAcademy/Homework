package kr.eddi.demo.entity.homework.seventh;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class LottoNumber {
    private int[] lottoNumArr;


    public void addLottoNumber(int min, int max) {
        int lottoIdx = 6;
        lottoNumArr = new int[lottoIdx];
        for (int i = 0; i < lottoIdx; i++) {
            int ranNum = CustomRandom.makeIntCustomRandom(min,max);
            lottoNumArr[i] = ranNum;
        }
    }
    public int getLottoNumber(int idx) {
        int lottoNum = lottoNumArr[idx];
        return lottoNum;
    }
}
