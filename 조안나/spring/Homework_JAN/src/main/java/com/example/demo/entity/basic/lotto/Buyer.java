package com.example.demo.entity.basic.lotto;

import com.example.demo.utillity.basic.lotto.Lotto;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Buyer implements Comparable<Buyer>{
    private LottoScore lottoScore;
    private String nickName;

    private final String DEFAULT = "anonymous";


    public Buyer() {
        nickName = DEFAULT;
        lottoScore = new LottoScore();
    }

    public void lottoSystemStart(List<Buyer> buyer){
            List<Integer> lottoNumbers =new ArrayList<>();
            lottoNumbers = Lotto.saveLottoNum(Lotto.pickingNum(buyer));
            lottoScore.lottoNumScore(lottoNumbers);
    }

    @Override
    public int compareTo(Buyer buyer){
        int srcScore = this.getLottoScore().getFinalLottoScore();
        int dstScore = buyer.getLottoScore().getFinalLottoScore();

        if (srcScore > dstScore) {
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
