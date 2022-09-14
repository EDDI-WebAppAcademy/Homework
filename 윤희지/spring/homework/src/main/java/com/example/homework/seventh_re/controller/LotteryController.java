package com.example.homework.seventh_re.controller;

import com.example.homework.seventh_re.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework/seventh-re")
public class LotteryController {
    private final int LOTTERY_SIZE = 6;
    private final int PLAYER_NUM = 100;

    private List<Player> players;
    private int playerNum;

    @GetMapping("lottery-game")
    public String openLotteryGame() {

        createPlayer();
        gameStart();

        return checkWinner();
    }

    private String checkWinner() {
        return null;
    }

    private void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).buyLotto();
        }

    }

    private void createPlayer() {
        players = new ArrayList<>();
        this.playerNum = PLAYER_NUM;
        createPlayerObj(players, playerNum);

    }

    private void createPlayerObj(List<Player> players, int playerNum) {
        for (int i = 0; i < playerNum; i++) {
            players.add(new Player("player" + (i+1)));
        }
    }

}
