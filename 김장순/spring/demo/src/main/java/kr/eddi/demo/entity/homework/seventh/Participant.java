package kr.eddi.demo.entity.homework.seventh;

import kr.eddi.demo.utility.homework.seventh.CustomLotto;
import lombok.Getter;

import java.util.List;

import static kr.eddi.demo.utility.homework.seventh.calculation.CompareLotto.compareLotto;
import static kr.eddi.demo.utility.homework.seventh.calculation.SpecialCalculation.specialCalc;

@Getter
public class Participant {

    private String nickName;
    private final String DEFAULT = "unknown";
    private  LottoScore lscore;
    public Participant() {
        nickName = DEFAULT;
        lscore = new LottoScore();
    }
    private List<List<Integer>> lottoAndLotto;

    public void runSystem(Participant parti[]){
        lottoAndLotto =
               compareLotto(CustomLotto.makeLotto(),CustomLotto.makeLotto());

        List<Integer> finalLottoList1 = lottoAndLotto.get(0);
        List<Integer> finalLottoList2 = lottoAndLotto.get(1);

        int result1 = specialCalc(finalLottoList1);
        int result2 = specialCalc(finalLottoList2);

        lscore.addScore(result1, result2);

    }

}
