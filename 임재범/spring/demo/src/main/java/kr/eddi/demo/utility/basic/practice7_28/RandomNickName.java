package kr.eddi.demo.utility.basic.practice7_28;

import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.Random;

public class RandomNickName {


    public String RandomNick(){

        String RandomNick;

        int num1 = CustomRandom.makeIntCustomRandom(65, 122);
        while(num1>=91 && num1<=96){
            num1 = CustomRandom.makeIntCustomRandom(65, 122);
        }
        String str1 = Integer.toString(num1); //대소문자 중 한개


        int num2 = CustomRandom.makeIntCustomRandom(65, 122);
        while(num2>=91 && num2<=96){
            num2 = CustomRandom.makeIntCustomRandom(65, 122);
        }
        String str2 = Integer.toString(num2); //대소문자중 한개.

        int ran3 = CustomRandom.makeIntCustomRandom(0, 99);//숫자
        String str3 = Integer.toString(ran3);

        RandomNick = str1+str2+str3; //ex) Ag30(랜덤하게 부여된 닉)



        return RandomNick;
    }
}
