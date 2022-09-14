package com.example.homework.seventh_re.utility;

import com.example.homework.utility.CustomRandom;

import java.util.List;

public class LotteryShop {
    final static int MIN = 0;
    final static int MAX = 99;

    public static int giveLotteryNum() {
            return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }
}
