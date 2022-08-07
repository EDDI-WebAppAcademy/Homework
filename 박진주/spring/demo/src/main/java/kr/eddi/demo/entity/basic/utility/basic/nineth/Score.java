package kr.eddi.demo.entity.basic.utility.basic.nineth;

import kr.eddi.demo.entity.basic.nineth.LottoCard;
import kr.eddi.demo.entity.basic.nineth.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Score {

    /** 클래스간 정보를 연결하는 방식에 대한 고찰
     *  score는 현재 클래스타입의 변수가 없음 -> 플레이어마다 카드 번호를 받아서 점수 계산을 해야 되는데도!
     *  (1) 그냥 자기 score 배열 생성
     *  (2) calcPlayersScore 점수 메소드 작성 => 여기서 인자를 List<Player> players 받아옴
     *  (3) 심지어 점수 메소드를 사용하는 winnerManager 클래스에서도 실제 객체에 값을 할당한 players 값을 받는다는게 없음 -> score클래스와 동일하게 단지 인자로 List<Player> players 받아옴
     *  (4) 결론적으로 최종 controller에서만 객체를 생성해서 메소드 등을 통해 값을 할당하고, winnermanager 클래스, LottoCardManager 클래스 등의 메소드를 호출하여 실행 시켜서 계산하는 방식
     */


    private static List<Integer> score = new ArrayList<>();                // 스코어 배열 생성

    // [ (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6
    public static void calcPlayersScore(List<Player> players) {        // 파라미터 플레이어 정보
        for (int i = 0; i < players.size(); i++) {
            LottoCard card = players.get(i).getCard();               // 카드는 플레이어 i의 카드값
            int[] numbers = card.getNumbers();                       // 플레이어 i가 가진 카드의 -> number 배열(6개 숫자) 추출

            if (numbers[5] == 0) {                              // 6번째 숫자가 0이면 나누기 0 못하므로 그냥 0점 처리
                score.add(0);
            } else {                                                              // 그 외에는 점수 산정
                score.add((numbers[0] + numbers[1] + numbers[2] + numbers[3]) *
                        numbers[4] / numbers[5]);
            }
        }
    }

    public static int getScore(int idx) {
        return score.get(idx);
    }
}