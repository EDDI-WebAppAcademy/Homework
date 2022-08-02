package choijaemin.homework.utility.fourth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FindTimesNum {
    public static int SumTimesNum = 0;
    /*
    리스트에 매개변수값의 1-100사이의 배수를 집어 넣습니다.
     */
    public static int TimesNums(int FindNum){
        for (int i = 1; i < 101; i++) {
            if (i % FindNum == 0){
                SumTimesNum += i;
            }
        }
        return SumTimesNum;
    }


    public static String TimesNums(int FindNum , String showNum){

        for (int i = 1; i < 101; i++) {
            if (i % FindNum == 0){
                showNum += i+",";
            }
        }
        return showNum;
    }
}
