package kr.eddi.demo.entity.seventh;

import kr.eddi.demo.utility.fourth.CustomRandom;
import lombok.Getter;



@Getter
public class RandomNumDrawLots {

    private static double[] lottoNum;
    private static final int LOTTO_MAX_NUM = 100;
    private static final int LOTTO_MIN_NUM = 1;
    private final int LOTTO_CNT = 6;

    public double lottoScore() {
        lottoNum = new double[LOTTO_CNT];
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = CustomRandom.makeCustomRandom(LOTTO_MIN_NUM,LOTTO_MAX_NUM);
        }

        double resultScore = (lottoNum[0] + lottoNum[1] + lottoNum[2] + lottoNum[3]) * lottoNum[4] / lottoNum[5];
        return resultScore;
    }
}
