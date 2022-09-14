package com.example.homework.seventh.controller;

import com.example.homework.seventh.entity.LottoBuyer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework7")
public class LottoRestController {
    private final int LOTTO_BUYER_NUM = 100;
    private final int MIN = 0;
    private final int MAX = 99;
    private final int LOTTO_SIZE = 6;
    private final long LOTTO_PAYOUT = 10000000000L;
    private int lottoBuyerNum;
    List<LottoBuyer> lottoBuyers;

    @GetMapping("/lotto")
    public String startLotto() {

        createPlayer();

        return null;
    }

    // 랜덤숫자 하나씩....주기...
    // 100명에게 1자리씩 하나씩 비교하면서 주기..(1번 주고 2번은 1번과... 3번은 1번 2번과...)
    // 그 다음에 자기의 앞 인덱스 번호와 중복여부 비교해서 번호 주기.

    public void createPlayer() {
        new ArrayList<>();
        this.lottoBuyerNum = LOTTO_BUYER_NUM;

        createBuyerObj(lottoBuyers, LOTTO_BUYER_NUM);
    }

    public void createBuyerObj(List<LottoBuyer> lottoBuyers, int lottoBuyerObjNum){
        for (int i = 0; i < lottoBuyerObjNum; i++) {
            lottoBuyers.add(new LottoBuyer("person" + (i+1)));
        }
    }

    public boolean checkSameNum(int temp) {
        // 플레이어 수 만큼 반복해서 체크
        for (int i = 0; i < lottoBuyers.size(); i++) {
            if (i == 0) {
                continue;
            } else if (i > 0) {
                // 우선 temp에 랜덤 숫자를 받고
                // i번째 lottoPersons 객체와 0 ~ i - 1번째 객체들의 랜덤숫자 중
                // 특정인덱스의 숫자와 temp가 중복되지 않으면
                // i번째 lottoPersons 객체의 ArrayList lottoNums 리스트에 추가하고 싶은데
                // 어떻게 짜야할지 모르겠습니다..ㅠㅠ...
                }
            }
        return true;
        }

    /*public void giveSpecialScore() {
        final int INDEX_OF_SUM_NUMS = 4;
        final int INDEX_OF_MULTIPLE_NUM = 5;
        final int INDEX_OF_DIVIDE_NUM = 6;


        for (int i = 0; i < LOTTO_BUYER_NUM; i++) {
            int sum = 0;
            int multiple = lottoBuyers.get(lotto.get(INDEX_OF_MULTIPLE_NUM - 1));
            int divide = lottoBuyers.get(lotto.get(INDEX_OF_DIVIDE_NUM - 1);
            int score = 0;

            if(divide == 0) {
                lottoBuyers.getSpecialScore().setScore(0);
            }

            for(int j = 0; j < INDEX_OF_SUM_NUMS; j++) {
                sum = lottoBuyers.getLotto().get(i);
            }
            score = (sum * multiple) / divide;
            lottoBuyers[i].getSpecialScore().setScore(score);
        }
    }
    * */

    public String findWinner() {
        String winners = "";

        return winners;
        }



    }

