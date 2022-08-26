package kr.eddi.demo.entity.homework.seventh;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Participant implements Comparable<Participant> {
    private final int MIN = 0;
    private final int MAX = 99;
    private final int pax = 100;
    private String nickName;
    private LottoScore lottoScore;

    private LottoNumber lottoNumber;

    public Participant() {
        this.nickName = "DEFAULT";
        lottoNumber = new LottoNumber();
        lottoScore = new LottoScore();
    }

    // 시스템 작동할 메서드 필요
    public void runSystem(List<Participant> participants, int ppIdx) {
        lottoNumber.addLottoNumber(MIN, MAX);
        int lottoResult = calScore();
        lottoScore.addLottoScore(lottoResult);

    }

    public int calScore() {
        int num1 = lottoNumber.getLottoNumber(0);
        int num2 = lottoNumber.getLottoNumber(1);
        int num3 = lottoNumber.getLottoNumber(2);
        int num4 = lottoNumber.getLottoNumber(3);
        int num5 = lottoNumber.getLottoNumber(4);
        int num6 = lottoNumber.getLottoNumber(5);

        int lottoResult = ((num1 + num2 + num3
                + num4) * num5) / num6;
        return lottoResult;
    }
    @Override
    public int compareTo(Participant participant) {
        int srcLottoScore = this.getLottoScore().getTotalLottoScore();
        int dstLottoScore = participant.getLottoScore().getTotalLottoScore();

        if (srcLottoScore > dstLottoScore) {
            return 1;
        } else if (srcLottoScore < dstLottoScore) {
            return -1;
        } else {
            return 0;
        }
    }

}


