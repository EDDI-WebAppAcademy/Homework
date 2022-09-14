package com.example.homework.pokergames.try2.utility;

import com.example.homework.pokergames.try2.entity.Player;

import java.util.List;
import java.util.Map;

public class JudgingMachine {

    public static int judgeCardRank(Map<Player, List<String>> eachPlayersOpenCards) {
        //스트레이트
        //
        return 0;
    }

    public static int judgeHighCard(Map<Player, List<String>> eachPlayersOpenCards) {
        int highCardPlayerIdx = 0;
        String [] highCard = eachPlayersOpenCards.get(0).get(0).split("-");
        for (int playerIdx = 1; playerIdx < eachPlayersOpenCards.size(); playerIdx++) {
            String [] compareCard = eachPlayersOpenCards.get(playerIdx).get(0).split("-");

            if(highCard[1].equals(compareCard[1])) {
                switch(compareCard[0]) {
                    case "SPADE":
                        highCard = compareCard;
                        highCardPlayerIdx += playerIdx;
                        break;

                    case "DIAMOND":
                        if(!highCard[0].equals("SPADE")) {
                            highCard = compareCard;
                            highCardPlayerIdx += playerIdx;
                            break;
                        }
                    case "HEART":
                        if(highCard[0].equals("CLUB")) {
                            highCard = compareCard;
                            highCardPlayerIdx += playerIdx;
                        }
                    case "CLUB":
                        break;
                }
            } else {
                int highCardScore = scoreChanger(highCard[1]);
                int compareCardScore = scoreChanger(compareCard[1]);
                if(compareCardScore > highCardScore) {
                    highCard = compareCard;
                    highCardPlayerIdx += playerIdx;
                }
            }
        }
        return highCardPlayerIdx;
    }

    private static int scoreChanger(String cardNum) {
        int changedCardNum = 0;
        if(!cardNum.equals("ACE") && !cardNum.equals("KING") && !cardNum.equals("QUEEN") && !cardNum.equals("JACK")) {
            changedCardNum = Integer.parseInt(cardNum);
        } else {
            switch(cardNum) {
                case "ACE":
                    changedCardNum = 14;
                    break;

                case "KING":
                    changedCardNum = 13;
                    break;

                case "QUEEN":
                    changedCardNum = 12;
                    break;

                case "JACK":
                    changedCardNum = 11;
                    break;
            }
        }
        return changedCardNum;
    }

    //아 이런..이런..!!!ㅋㅋㅋㅋㅋ주먹구구로 만들다보니 이런 참사가..!!!ㅋㅋㅋㅋㅋ

}
