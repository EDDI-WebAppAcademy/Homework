package kr.eddi.homework.utility.eighth;

import kr.eddi.homework.utility.basic.third.CustomRandom;

import java.util.ArrayList;

public class Lotto {
    private static final int MIN = 0;
    private static final int MAX = 99;


    public static int doLotto(){
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }
}
