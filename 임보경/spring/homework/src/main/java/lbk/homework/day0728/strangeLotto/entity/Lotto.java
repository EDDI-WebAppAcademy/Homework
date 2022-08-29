package lbk.homework.day0728.strangeLotto.entity;

import lombok.Getter;

import java.util.ArrayList;
import static lbk.homework.day0728.strangeLotto.utility.CustomRandom.makeCustomRandom;

@Getter
public class Lotto {
    private final int MIN = 0;
    private final int MAX = 99;
    private final int LIMIT_LOTTO_NUMBER = 6;
    private ArrayList<Integer> sixNumber;

    public Lotto() {
        sixNumber = new ArrayList<Integer>();
    }
    public int calFinalNumber() {
        int first = sixNumber.get(0);
        int second = sixNumber.get(1);
        int third = sixNumber.get(2);
        int fourth = sixNumber.get(3);
        int fifth = sixNumber.get(4);
        int sixth = sixNumber.get(5);

        return ((first+second+third+fourth) * fifth) / sixth;
    }

    public void perfectNumber() {
        while(sixNumber.size() != 6) {
            pullUpNumber();
        }
    }
    public void pullUpNumber() { // 한사람 번호에서의 중복번호 없음
        int tmp = makeCustomRandom(MAX, MIN);
        if (!sixNumber.contains(tmp)) {sixNumber.add(tmp);}
    }

}

