package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.CustomRandomNum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question10_SumRanNumLoopHundred {
    private final int MAX = 10;
    private final int MIN = 2;
    private int totalSum= 0;
    private int RandomNum;


    public int showTotalSum(){
        for (int i = 1; i < 100;) {
            RandomNum = CustomRandomNum.makeRandomNum(MIN, MAX);
            totalSum += RandomNum;
            i += RandomNum;
        }
        return totalSum;
    }
}
