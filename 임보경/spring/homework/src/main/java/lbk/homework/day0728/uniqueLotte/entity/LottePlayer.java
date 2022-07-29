package lbk.homework.day0728.uniqueLotte.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static lbk.homework.day0728.uniqueLotte.utility.CustomRandom.makeCustomRandom;

@Slf4j
@Getter
public class LottePlayer {

    private String name;
    private String[] namesExample = {"도박사", "운명을개척하려는자", "갬블러", "규칙적인구매자", "플레이어"};
    private Lotte lotte;

    public LottePlayer(int idx) {
        this.name = makeRandomPlayerName(idx);
        lotte = new Lotte();
    }
    public String makeRandomPlayerName(int idx) {
        return namesExample[
                makeCustomRandom(namesExample.length - 1, 0)]
                + (idx + 1);
    }

}
