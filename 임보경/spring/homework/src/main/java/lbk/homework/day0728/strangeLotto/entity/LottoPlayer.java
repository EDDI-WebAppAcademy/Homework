package lbk.homework.day0728.strangeLotto.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static lbk.homework.day0728.strangeLotto.utility.CustomRandom.makeCustomRandom;

@Slf4j
@Getter
public class LottoPlayer {

    private String name;
    private String[] namesExample = {"도박사", "운명개척자", "갬블러", "규칙적인구매자", "플레이어"};
    private Lotto lotto;

    public LottoPlayer(int idx) {
        this.name = makeRandomPlayerName(idx);
        lotto = new Lotto();
    }

    public String makeRandomPlayerName(int idx) {
        return namesExample[
                makeCustomRandom(namesExample.length - 1, 0)]
                + (idx + 1);
    }

}
