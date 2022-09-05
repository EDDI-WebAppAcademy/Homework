package com.example.homework.seventh.utility;

import com.example.homework.seventh.entity.LottoBuyer;

import java.util.List;

public interface WinnerAlgorithm {
    public void lottoWinnerRule(List<LottoBuyer> buyers, int buyersIdx, int lottoIdx);
}
