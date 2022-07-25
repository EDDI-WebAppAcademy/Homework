package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.CustomRandomNum;
import choijaemin.homework.utility.fourth.FindTimesNum;

import java.util.ArrayList;

public class Question8_PrintRanNumMultiple {
    private int RandomNum;
    private String showRandomTimesNum = "";
    private final int MAX = 10;
    private final int MIN = 2;

    public String ranNumMultiple(){
        RandomNum = CustomRandomNum.makeRandomNum(MIN,MAX);

        return FindTimesNum.TimesNums(RandomNum,showRandomTimesNum);
    }
}
