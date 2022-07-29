package kr.eddi.demo.entity.eight;

import kr.eddi.demo.utility.eight.lotto.MakeLotto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LottoBuyer {

    private String name;
    private int total;
    List<Integer> lottoNums;

    public LottoBuyer() {
        lottoNums = MakeLotto.makeLottoNumsList();
    }

}
