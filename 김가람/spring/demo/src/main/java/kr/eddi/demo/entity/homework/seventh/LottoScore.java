package kr.eddi.demo.entity.homework.seventh;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LottoScore { // 점수를 받아서 플레이어에 전달

    private int totalLottoScore;

    public void addLottoScore(int lottoResult) {
        totalLottoScore += lottoResult;
    }

}
