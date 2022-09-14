package kr.eddi.demo.utility.homework.seventh.calculation;

import java.util.List;

public class SpecialCalculation {

    public static int specialCalc(List<Integer> lotto) {
        int n1 = lotto.get(0);
        int n2 = lotto.get(1);
        int n3 = lotto.get(2);
        int n4 = lotto.get(3);
        int n5 = lotto.get(4);
        int n6 = lotto.get(5);

        return ((n1 + n2 + n3 + n4) * n5) / n6;
    }

}
