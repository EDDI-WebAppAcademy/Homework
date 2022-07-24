package choijaemin.homework.entity.fourth;

import java.util.ArrayList;

public class Question6_PrintThreeTimesNum {
    private ArrayList ThreeTimesNum = new ArrayList();
    
    public ArrayList threeTimesNum(){

        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0){
                ThreeTimesNum.add(i);
            }
        }
        
        return ThreeTimesNum;
    }
}
