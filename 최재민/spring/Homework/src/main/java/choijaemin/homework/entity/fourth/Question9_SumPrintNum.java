package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.CustomRandomNum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
@Setter
public class Question9_SumPrintNum {
    private final int MAX = 10;
    private final int MIN = 2;
    private int totalSum= 0;
    private int RandomNum;

    private String string = "";
    public String showRanNumMultiple(){

        for (int i = 1; i < 101; i++) {
            RandomNum = CustomRandomNum.makeRandomNum(MIN, MAX);
            string += (RandomNum * 2) +",";
            totalSum += (RandomNum *2);
        }
        return String.format("랜덤수의 배수 : %s,총합 : %d" , string ,totalSum );
    }
}
