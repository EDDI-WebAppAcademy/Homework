package kr.eddi.demo.controller.homework.homework0728;


import kr.eddi.demo.utilty.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Lotto {


    private static final int LOTTONUM = 6;
    private static final int LOTTOLIMIT = 45;

    private final int LOTTOSTART = 0;
    private final int LOTTOEND = 99;


    static List<Integer> lottoList = new ArrayList<>();


    public static List<Integer> lottoNUM(){

        int count = 0;

        while(count < LOTTONUM){
            Integer ranNum = CustomRandom.makeIntCustomRandom(LOTTONUM,LOTTOLIMIT);


        }


    }



}
