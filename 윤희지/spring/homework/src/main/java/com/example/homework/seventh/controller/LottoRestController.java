package com.example.homework.seventh.controller;

import com.example.homework.seventh.entity.LottoPerson;
import com.example.homework.utility.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/seventh-homework")
public class LottoRestController {
    final int LOTTO_PERSON_NUM = 100;
    final int MIN = 0;
    final int MAX = 99;
    final int LOTTO_SIZE = 6;
    final long LOTTO_PAYOUT = 1000000000;
    LottoPerson[] lottoPersons = new LottoPerson[LOTTO_PERSON_NUM];

    @GetMapping("/lotto")
    public String startLotto() {
        String msg = "";

        for (int i = 0; i < LOTTO_PERSON_NUM - 1; i++) {
            lottoPersons[i] = new LottoPerson("person" + i);
        }

        return msg;
    }

    // 랜덤숫자 하나씩....주기...
    // 100명에게 1자리씩 하나씩 비교하면서 주기..(1번 주고 2번은 1번과... 3번은 1번 2번과...)
    // 그 다음에 자기의 앞 인덱스 번호와 중복여부 비교해서 번호 주기.
    public void buyLotto() {
        for (int i = 0; i < LOTTO_PERSON_NUM; i++) {
            int randomNum;
            int temp;
            randomNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
            lottoPersons[i].getLottoNums().add(randomNum);


            while(true) {
                temp = CustomRandom.makeIntCustomRandom(MIN, MAX);
                if(randomNum != temp) {
                    randomNum = temp;
                    lottoPersons[i+1].getLottoNums().add(randomNum);
                }
            }
        }


    }

    public void checkSameNum() {

    }

    public void findWinner() {
        for (int i = 0; i < LOTTO_PERSON_NUM; i++) {
            for(int j = 0; j < lottoPersons[i].getLottoNums().size(); j++) {

            }
        }

    }

}
