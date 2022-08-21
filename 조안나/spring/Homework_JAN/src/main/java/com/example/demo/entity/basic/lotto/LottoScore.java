package com.example.demo.entity.basic.lotto;

import com.example.demo.utillity.basic.lotto.Lotto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LottoScore {

private List<Integer> lottoNumbers;
private Lotto lotto = new Lotto();
private int finalLottoScore;

    public int lottoNumScore(List<Integer> lottoNumbers){
        finalLottoScore = lottoNumSum(lottoNumbers);
        return finalLottoScore;
    }


    /**
     * 랜덤으로 뽑힌 번호들을 연산해주는 메서드
     * @param lottoNumbers 로또 번호가 담긴 리스트
     * @return 연산된 값의 합
     */
    public int lottoNumSum(List<Integer> lottoNumbers){
        int add = 0;
        int mul = 0;
        int sum = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            add += lottoNumbers.get(i);
            if(i == lottoNumbers.size() - 2){
                mul = add * lottoNumbers.get(i);
            }
            if(i == lottoNumbers.size() - 1){
                if(lottoNumbers.get(i) == 0){
                    sum = -4444;
                }else {
                    sum = mul / lottoNumbers.get(i);
                }
            }
        }
        return sum;
    }
}
