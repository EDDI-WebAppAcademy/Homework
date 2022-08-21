package com.example.demo.controller.basic.lotto;


import com.example.demo.entity.basic.lotto.Buyer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lotto")
public class LottoController {

    private final int DEFAULT_BUYER_NUM = 50;
    private final int MAX_BUYER_NUM = 100;
    private final int LOTTO_NUM = 6;
    private final long PRIZE_MONEY = 10000000000L;
    private int buyerNum;

    private List<Buyer> buyer;

    @GetMapping("/special-System")
    public String lottoSystemStarter(){
        createBuyer();
        log.info("createBuyer()");

        lottoSystemStart();
        log.info("lottoSystemStart()");

        return announcementWinner();
    }

    public void createBuyer(){
        buyer = new ArrayList<>();
        this.buyerNum = DEFAULT_BUYER_NUM;

        createBuyerObj(buyer, DEFAULT_BUYER_NUM);
    }


    public void createBuyerObj(List<Buyer> buyer, int buyerObjNum){
        for (int i = 0; i < buyerObjNum; i++) {
            buyer.add(new Buyer());
        }
    }

    public void lottoSystemStart(){
        if(DEFAULT_BUYER_NUM <= MAX_BUYER_NUM){
            for (int i = 0; i < buyerNum; i++) {
                buyer.get(i).lottoSystemStart(buyer);
            }
        }
    }


    public String announcementWinner(){
        log.info("정렬 전 : " + String.valueOf(buyer));

        Collections.sort(buyer);

        log.info("정렬 후  :" + String.valueOf(buyer));

        int maxPlayerScore = acquirePlayerTotalScore(buyerNum - 1);

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = buyerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore) { break; }

            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 1){
            int SameScoreCnt = sameScoreIdxList.size();
            return String.format("%d 명 당첨!!! 축하합니다. %n 각 상금 %d 원",
                    SameScoreCnt, distributionPrize(SameScoreCnt, PRIZE_MONEY));
       }
        return String.format("당첨자: %s 님 축하합니다.%n 당첨금 : %d 원",
                buyer.get(buyerNum - 1).getNickName(), PRIZE_MONEY);

    }

    public int distributionPrize(int winnerNum, long PRIZE_MONEY){
        return (int) PRIZE_MONEY / winnerNum;
    }

    public int acquirePlayerTotalScore(int idx) {
        return buyer.get(idx).getLottoScore().getFinalLottoScore();
    }

}
