package com.example.homework.pokergames.try2.entity;

import com.example.homework.pokergames.try2.utility.JudgingMachine;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class RoundManager {
    private Trump trump;
    private final int PRE_ROUND = 3;
    private final int MAIN_ROUND_NUM = 4;
    private final boolean OPEN = true;
    private final boolean CLOSE = false;
    private int nextFirstPlayerIdx;

    // 0라운드: 3장 받기 -> 오픈카드 1장 공개 -> 하이카드 판정(오픈카드 1장) ->1라운드 선 정하기(하이카드 플레이어 idx 뱉)
    // 1라운드: 베팅-> 오픈카드 1장 받기(오픈카드 2) -> 2라운드 선 정하기
    // 2라운드: 베팅-> 오픈카드 1장 받기(오픈카드 3) -> 3라운드 선 정하기
    // 3라운드: 베팅-> 오픈카드 1장 받기(오픈카드 4) -> 4라운드 선 정하기
    // 4라운드: 베팅-> 히든카드 1장 받기(게임 끝. 손카드 총 7장으로 최고 조합 가리기)

    public void playGame(PlayerManager playerManager) {
        trump = new Trump();
        trump.shuffle();

        // 4. 참여 순서대로 플레이어들에게 패를 돌린다.
        // 선 정하고 순서대로 베팅하고 카드 받기 * 4(단, 마지막은 히든카드)
        // 아하 이 부분을......라운드 수에 따라서 알아서~ 나눠주게 만들면 더 좋을거 같긴 한뎁..
        for (int i = 0; i < PRE_ROUND; i++) {
            dealCards(trump, playerManager, CLOSE);
        }
        // 5. 플레이어들은 공개할 패를 선택한다.
        playerManager.openPlayerCard();

        // 6. 라운드를 시작한다.
        doMainGame(playerManager);

    }

    private void doMainGame(PlayerManager playerManager) {
        // 처음에 전라운드에서 오픈한 카드목록 가지고 선을 정해야 4번 반복을 시킬 수가 있따..
        for (int i = 0; i < MAIN_ROUND_NUM; i++) {
            judgePriority(i, playerManager);
            if (i != 3) {
                dealCards(trump, playerManager, OPEN);
            } else {
                dealCards(trump, playerManager, CLOSE);
            }
        }
    }

    // 얘는 playerManager로 옮기는 게 나은 거 같기도...?
    // 왜냐면 플레이 순서가 플레이어와 관련된 정보라서..??? 근데 플레이 순서는 라운드랑 관련 잇는거 같기도 하고..
    // 근데 객체 불러오기가 개빡세서 옮기고 싶기도 함ㅋ,,,쩜의 향연ㅋ
    private void judgePriority(int roundNum, PlayerManager playerManager) {
        // 각 player들의 open 카드를 비교하기 위한 Map 객체 생성.
        Map<Player, List<String>> MapEachPlayersOpenCards = new HashMap<>();
        // 플레이어의 카드중 오픈카드만 고르기
        for (int i = 0; i < playerManager.getPlayerNum(); i++) {
            // String 타입 ArrayList openCards를 만든다
            List<String> openCards = new ArrayList<>();
            // for each문을 돌면서..i번째 플레이어의 카드키 값을 받아와서
            for (String openCard : playerManager.getPlayers().get(i).getCards().keySet()) {
                // value가 OPEN이면 openCards에 넣어
                if (playerManager.getPlayers().get(i).getCards().get(openCard).equals(OPEN)) {
                    openCards.add(openCard);
                }
            }
            System.out.println("플레이어 " + playerManager.getPlayers().get(i).getName() + "의 오픈카드");
            System.out.println(openCards);
            //플레이어를 키 값으로 줘서 짝짓기 해가지고 map객체에 put
            MapEachPlayersOpenCards.put(playerManager.getPlayers().get(i), openCards);
        }
        if (roundNum == 0) {
            nextFirstPlayerIdx = JudgingMachine.judgeHighCard(MapEachPlayersOpenCards);
        } else {
            nextFirstPlayerIdx = JudgingMachine.judgeCardRank(MapEachPlayersOpenCards);
        }
        System.out.println("이번 라운드의 선 플레이어는 " + playerManager.getPlayers().get(nextFirstPlayerIdx).getName() + "입니다.");
    }

    public void dealCards(Trump trump, PlayerManager playerManager, boolean openOrClose) {
        for (int playerIdx = 0; playerIdx < playerManager.getPlayerNum(); playerIdx++) {
            String card = trump.getCardDeck().get(0);
            playerManager.getPlayers().get(playerIdx).getCards().put(card, openOrClose);
            trump.getCardDeck().remove(0);
        }

    }
}
