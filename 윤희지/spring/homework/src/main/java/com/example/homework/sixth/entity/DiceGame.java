package com.example.homework.sixth.entity;

import java.util.Arrays;

public class DiceGame {
    private Player[] players;
    private Dice dice;

    public DiceGame(int playerNum) {
        players = new Player[playerNum];
        dice = new Dice();
        for (int i = 0; i < playerNum; i++) {
            players[i] = new Player("player" + (i + 1));
        }
    }

    public void playGame() {
        for (int i = 0; i < players.length; i++) {
            dice.rollDice();
            players[i].getScore().gainScore(dice.getDiceNum());

            if (dice.getDiceNum() % 2 != 0) {
                dice.rollDice();
                if (dice.getDiceNum() == 4) {
                    continue;
                } else {
                    switch (dice.getDiceNum()) {
                        // 모두 2점씩 감소
                        case 1:
                            for(int j = 0; j < players.length; j++) {
                                    players[j].getScore().looseScore(2);
                                }
                            break;
                        //플레이어는 + 3*(인원수 - 1), 나머지는 -3
                        case 3:
                            for(int j = 0; j < players.length; j++) {
                                if(i == j) {
                                    players[j].getScore().gainScore((players.length-1)*3);
                                } else {
                                    players[j].getScore().looseScore(3);
                                }
                            }
                            break;

                        //플레이어는 -2 *(인원수 - 2), 나머지는 +2
                        case 5:
                            for(int j = 0; j < players.length; j++) {
                                if(i == j) {
                                    players[j].getScore().looseScore((players.length-1)*2);
                                } else {
                                    players[j].getScore().gainScore(2);
                                }
                            }
                            break;

                        default:
                            players[i].getScore().gainScore(dice.getDiceNum());
                            break;
                    }
                }
            }
        }
    }

    public String findWinner() {
        String winner = "";
        for(int i = 0; i < players.length - 1; i++) {
             if(players[i].getScore().getScore() > players[i+1].getScore().getScore()) {
                 Player temp = players[i];
                 players[i] = players[i + 1];
                 players[i+1] = temp;
             }
        }
        winner = players[players.length - 1].getName();


        return "우승자는 " + winner + "입니다!";
    }

}