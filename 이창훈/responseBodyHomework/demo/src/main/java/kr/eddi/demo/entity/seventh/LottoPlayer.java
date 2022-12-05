package kr.eddi.demo.entity.seventh;

import lombok.Getter;
import lombok.Setter;

@Setter
public class LottoPlayer {

    private RandomNumDrawLots randomNumDrawLots;

    private String nickname;
    private double score;

    public LottoPlayer() {
        nickname = ""; // 랜덤닉네임 생성
//        nickname += 랜덤문자
        score = playerScore();
    }

    public double playerScore() {
        return randomNumDrawLots.lottoScore();
    }

}
