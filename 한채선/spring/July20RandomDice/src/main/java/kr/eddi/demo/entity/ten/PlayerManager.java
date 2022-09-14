package kr.eddi.demo.entity.ten;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class PlayerManager {
  /*  int playerNum;
    private  PokerCard pokerCard;
    private List<Player> playerList;
    private Map<Player, List<Map<CardShape, CardCharacter>>> playerPublishedDeck;

    public PlayerManager(int playerNum) {
        this.playerNum = playerNum;
        playerList = new ArrayList<>();
        pokerCard = new PokerCard();
        pokerCard.shuffle();
        playerPublishedDeck = new HashMap<>();

        for (int i = 0; i < playerNum; i++) {
            playerList.add(new Player());
        }
    }


    public void playPokerGame(int currentRound) {
        //4. 참여 순서대로 플레이어들에게 패를 돌린다 -> 카드 생성
        for (int i = 0; i < playerNum; i++) {
            aquireNewCard(i, currentRound);

            }
        }
    }
  public void publishingPlayerCard(int playerIdx, int currentRound) {
        List<Map<CardShape, CardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
        if(currentRound == 0) {
            newPlayerPublishingDeckList.add(playerList.get(playerIdx).publishingPlayerCard());
        }

        List<Map<CardShape, CardCharacter>> existingPlayerPublishedDeckList;

        if (playerPublishedDeck.get(playerList.get(playerIdx)) == null) {
            existingPlayerPublishedDeckList = newPlayerPublishingDeckList;
        } else {
            existingPlayerPublishedDeckList = playerPublishedDeck.get(playerIdx);
        }

    }

    private void aquireNewCard(int playerIndex, int currentRound) {
        if(currentRound == 0) {

        }
    }*/
}
