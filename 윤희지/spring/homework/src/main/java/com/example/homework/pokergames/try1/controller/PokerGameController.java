package com.example.homework.pokergames.try1.controller;


import com.example.homework.pokergames.try1.entity.Player;
import com.example.homework.pokergames.try1.entity.Trump;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework9")
public class PokerGameController {
    private List<Player> players = new ArrayList<>();;
    private BigInteger pot= new BigInteger("0");
    private Trump trump;
    private final int PLAYER_NUM = 1;
    private final int FIRST_SPLIT = 3;

    @GetMapping("/poker-game")
    public String startPokerGame() {
        log.info("포커 게임을 시작합니다.");
        Player computer = new Player("computer");
        players.add(computer);
        trump = new Trump();

        log.info("플레이어가 입장합니다.");
        playerEnter(PLAYER_NUM);

        log.info("트럼프 카드를 셔플합니다.");
        trump.shuffle();

        log.info("처음으로 카드를 분배합니다.");
        splitCards(FIRST_SPLIT);

        log.info("하이 카드를 오픈합니다.");


        log.info("카드가 가장 높은 사람부터 오픈 카드를 받습니다.");

        log.info("카드가 가장 높은 사람부터 베팅을 시작합니다.");



        return null;
    }

    public void splitCards(int splitCount) {
        switch (splitCount) {

            // 한명당 한장씩 세 번 나눠주게 수정....한명한테 3장 연속 말고..ㅠㅠ...
            case FIRST_SPLIT:
                for (int i = 0; i < PLAYER_NUM + 1; i++) {
                    for (int cardIdx = 0; cardIdx < FIRST_SPLIT; cardIdx++) {
                        String card = trump.getCardDeck().get(cardIdx);
                        players.get(i).getCards().add(card);
                        trump.getCardDeck().remove(cardIdx);
                    }
                    System.out.println(players.get(i).getCards().toString());
                }
                break;

        }

    }

    private void playerEnter(int playerNum) {
        for (int i = 0; i < PLAYER_NUM; i++) {
            players.add(new Player());
        }
    }


}
