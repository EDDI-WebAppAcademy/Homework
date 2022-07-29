package kr.eddi.demo.controller.homework.homework0728;


import java.util.List;

public class LottoCal {

    public static int LottoCalc(List<Integer> lootonum){

        int num1 = lootonum.get(0);
        int num2 = lootonum.get(1);
        int num3 = lootonum.get(2);
        int num4 = lootonum.get(3);
        int num5 = lootonum.get(4);
        int num6 = lootonum.get(5);

        return ((num1 + num2 + num3 + num4 )* num5) / num6;

    }


}
