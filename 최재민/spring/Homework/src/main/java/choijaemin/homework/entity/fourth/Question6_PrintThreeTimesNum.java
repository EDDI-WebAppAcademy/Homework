package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.FindTimesNum;

import java.util.ArrayList;

public class Question6_PrintThreeTimesNum {
    private final int CHOICENUM = 4;
    private String ShowNum ="";
    
    public String FindTimesNum(){
        return FindTimesNum.TimesNums(CHOICENUM,ShowNum);
    }
}
