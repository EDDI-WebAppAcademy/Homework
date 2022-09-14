package com.example.homework.seventh.entity;

import com.example.homework.seventh.utility.WinnerAlgorithm;
import com.example.homework.utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class LottoShop implements WinnerAlgorithm {
    private final int MIN = 0;
    private final int MAX = 99;

    public void giveLottoNum(List<Integer> lotto, int lottoSize) {
        List<Integer> tempLotto = new ArrayList<>();
        int randomNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        tempLotto.add(randomNum);

            for(int i = 0; i < tempLotto.size(); i++) {
                while(true) {
                    int temp = CustomRandom.makeIntCustomRandom(MIN, MAX);
                    if(tempLotto.get(i) != temp) {
                        randomNum = temp;
                        tempLotto.add(randomNum);
                        break;
                    }
                }


            }

        }


        @Override
        public void lottoWinnerRule (List < LottoBuyer > buyers,int buyersIdx, int lottoIdx){
            //buyers.get(buyersIdx).getLotto(lottoIdx);
        }
    }
