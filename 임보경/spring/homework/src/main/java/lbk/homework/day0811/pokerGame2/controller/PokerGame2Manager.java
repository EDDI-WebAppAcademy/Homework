package lbk.homework.day0811.pokerGame2.controller;

import lbk.homework.day0811.pokerGame2.entity.Player;
import lbk.homework.day0811.pokerGame2.entity.Round;
import lbk.homework.day0811.pokerGame2.utility.SettingCards;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


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
        round = new Round();
    }




    public void managementDividing() {
        int currentRound = round.getCurrentRound();

        if (currentRound == 0) {
            for (int i = 0; i < 3; i++) {
                dividingCard();
            }
        } else {
            dividingCard();
        }


        for (int i = 0 ; i < 2 ; i++) {
            System.out.println(players.get(i).getHand().getAllMyHand().toString());
        }
    }

    public void dividingCard() {
        for (int playerIdx = 0; playerIdx < numOfPlayer; playerIdx++) {
            players.get(playerIdx).getHand().getAllMyHand().add(settingCards.getCards().get(0));
            settingCards.getCards().remove(0);
        }
    }



    public void matchingPlayer() {
        players = new ArrayList<>();
        this.numOfPlayer = DEFAULT;

        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player(i));
        }
    }
}
