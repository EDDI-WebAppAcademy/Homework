package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.Player;
import kr.eddi.demo.utility.basic.practice7_28.Score;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
public class WinnerManager {
    private Map<Player, Integer> winnerScoreMap; //Map생성

    public WinnerManager() {
        winnerScoreMap = new HashMap<>();
    } //winnerScoreMap을 HashMap으로 선언.(key,value)

    //이 메서드는 플레이어정보가 담긴 리스트인 players를 전달받아 그 리스트에 담긴 플레이어들의 점수를 기준으로 정렬하여 정렬된 리스트를 리턴해줍니다.
    public List sortWinner(List<Player> players) {
        Score.calcPlayersScore(players); //유틸리티클래스 Score의 calcPlayersScore()는 플레이어정보에 접근해서, 환산점수를 계산하여,
                                         // 그 점수를 각 Player의 Score에 저장합니다.

        for (int i = 0; i < players.size(); i++) {
            winnerScoreMap.put(players.get(i), Score.getScore(i)); //i번째 플레이어, i번째 플레이어의 점수를 한 쌍으로 winnerScoreMap에 저장해 나갑니다.
        }

        List<Map.Entry<Player, Integer>> winner = winnerScoreMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList()); //플레이어의 점수(value)를 기준으로 정렬합니다. 다소 복잡했던거 같음.

        System.out.println(winner);

        return winner;
    }

    //
    public void doReward(List winner) {
        Map.Entry<Player, Integer> first = (Map.Entry<Player, Integer>) winner.get(winner.size() - 1); //가장 점수(value)가 높은 플레이어의 HashMap을 리턴합니다.
        int top = first.getValue(); //해시맵에서 점수만 빼옵니다.
        int cnt = 0;

        for (int i = winner.size() - 2; i >= 0; i--) {
            if (top == ((Map.Entry<Player, Integer>) winner.get(i)).getValue()) {
                cnt++; //동점자 있을시 cnt를 하나 늘림.
            }
            else {
                System.out.println("단일 우승 - 승자명: " + first.getKey().getNickName());
                return;
            }
        }

        BigInteger reward = new BigInteger("10000000000"); //int형 변수의 범위를 넘어간 숫자 100억.
        reward.divide(BigInteger.valueOf(cnt)).toString(); //동점자 있을 시 상금 n빵

        System.out.println("reward: " + reward);

        //동점자가 있는 경우를 고려한 승자발표
        for (int i = winner.size() - cnt - 1; i < winner.size(); i++) {
            System.out.println("승자명: " + ((Map.Entry<Player, Integer>) winner.get(i)).getKey().getNickName());
        }
    }
}
