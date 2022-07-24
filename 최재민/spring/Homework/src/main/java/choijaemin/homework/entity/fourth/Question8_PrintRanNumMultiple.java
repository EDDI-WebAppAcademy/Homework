package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.CustomRandomNum;

import java.util.ArrayList;

public class Question8_PrintRanNumMultiple {
    private int RandomNum;
    private ArrayList RanNumMultiple = new ArrayList();
    private final int MAX = 10;
    private final int MIN = 2;

    public ArrayList ranNumMultiple(){
        RandomNum = CustomRandomNum.makeRandomNum(MIN,MAX);
        for (int i = 1; i < 101; i++) {
            if (i % RandomNum== 0){
                RanNumMultiple.add(i);
            }
        }
        return RanNumMultiple;
    }
}
