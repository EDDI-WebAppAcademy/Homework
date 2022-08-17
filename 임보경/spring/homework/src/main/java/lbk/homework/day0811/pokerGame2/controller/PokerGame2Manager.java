package lbk.homework.day0811.pokerGame2.controller;

import lbk.homework.day0811.pokerGame2.entity.*;
import lbk.homework.day0811.pokerGame2.utility.SettingCards;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class PokerGame2Manager {

    private List<Player> players;
    private SettingCards settingCards;
    private Round round;
    private int numOfPlayer;
    private final int DEFAULT = 2;


    public PokerGame2Manager() {
        matchingPlayer();
        settingCards = new SettingCards(); // 카드 셔플 생성.
        round = new Round(); // 라운드 생성
    }



    public void selectCardTime() {
        for (int i = 0; i < numOfPlayer; i++) {
            System.out.println(players.get(i).getName() + "이 카드를 선택합니다.");
            players.get(i).selectCard();
        }
    }

    public void findSameCardNumber() {
        for (int i = 0; i < numOfPlayer; i++) {
            players.get(i).checkSameCardsNumber();
            players.get(i).checkSameCardsShape();
        }
    }

    //카드 분배
    public void managementDividing() {
        int currentRound = round.getCurrentRound();

        if (currentRound == 1) {
            for (int i = 0; i < 3; i++) {
                dividingCard(currentRound);
            }
        }else {
            dividingCard(currentRound);
        }

        for (int i = 0 ; i < 2 ; i++) {
            System.out.println("내가 가진 모든 패들 : " + players.get(i).getHand().getAllMyHand().toString());
            System.out.println("공개된 패들 : " + players.get(i).getHand().getTheRevealedHand().toString());
        }
    }

    public void dividingCard(int currentRound) {
        if (currentRound == 1) {
            for (int playerIdx = 0; playerIdx < numOfPlayer; playerIdx++) {
                players.get(playerIdx).getHand().getAllMyHand().add(settingCards.getCards().get(0));
                settingCards.getCards().remove(0);
            }
        } else {
            for (int playerIdx = 0; playerIdx < numOfPlayer; playerIdx++) {
                players.get(playerIdx).getHand().getAllMyHand().add(settingCards.getCards().get(0));
                players.get(playerIdx).getHand().getTheRevealedHand().add(settingCards.getCards().get(0));
                settingCards.getCards().remove(0);
            }
        }

    }



    // 플레이어 모집
    public void matchingPlayer() {
        players = new ArrayList<>();
        this.numOfPlayer = DEFAULT;

        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player(i));
        }
    }


    public void pass(){
        round.nextTurn();
        round.playPockerGame();
    }

}
