package choijaemin.homework.entity.fourth;

import java.util.ArrayList;

public class Question5_PrintEvenMumber {
    private ArrayList EvenNum = new ArrayList();

    public ArrayList evenMumber(){
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0){
                EvenNum.add(i);
            }
        }

        return EvenNum;
    }

}
