package kr.eddi.demo.controller.basic.nineth;

import kr.eddi.demo.entity.basic.nineth.LottoCardManager;
import kr.eddi.demo.entity.basic.nineth.Player;
import kr.eddi.demo.entity.basic.nineth.WinnerManager;
import kr.eddi.demo.entity.basic.utility.basic.nineth.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nineth")

/** 클래스별 역할
 *  컨트롤러 역할 - Player, LottoManager, WinnerManager 클래스 정보 받아서 실제 값이 있는 객체 생성하고 여러 클래스의 메소드 호출해서 값을 할당받아 계산하여 결과값 리턴
 *  로또카드매니저 역할 - 각 플레이어의 카드 리스트 생성 + 유효한 카드 값인지 체크
 *  로또카드 역할 - 로또 낱개 숫자 추첨 + (개인) 6개 로또 숫자 리스트 생성
 *  플레이어 역할 - 플레이어 생성 -> 닉네임 할당 + 플레이어의 카드 정보 얻을 수 있는 메소드 보유
 *  위너매니저 역할 - 플레이어 정보 인자로 받음 -> 점수 계산 메소드 실행 - 위너 판정 + 보상 메소드
 *  점수 역할  - 플레이어 정보 인자로 받아 점수 계산 (플레이어 변수 x)
 */

/** 클래스간 정보를 연결하는 방식에 대한 고찰
 *  score는 현재 클래스타입의 변수가 없음 -> 플레이어마다 카드 번호를 받아서 점수 계산을 해야 되는데도!
 *  (1) 그냥 자기 score 배열 생성
 *  (2) calcPlayersScore 점수 메소드 작성 => 여기서 인자를 List<Player> players 받아옴
 *  (3) 심지어 점수 메소드를 사용하는 winnerManager 클래스에서도 실제 객체에 값을 할당한 players 값을 받는다는게 없음 -> score클래스와 동일하게 단지 인자로 List<Player> players 받아옴
 *  (4) 결론적으로 최종 controller에서만 객체를 생성해서 메소드 등을 통해 값을 할당하고, winnermanager 클래스, LottoCardManager 클래스 등의 메소드를 호출하여 실행 시켜서 계산하는 방식
 */

public class NinethLottoGameController {

    private List<Player> players;        // 플레이어 클래스 타입의 list 변수
    private LottoCardManager lottoManager;
    private final int MAX_PLAYER = 100;
    private Score scoreManager;
    private WinnerManager winnerManager;

    @GetMapping("/lotto-game")
    public String lottoGame() {
        log.info("lottoGame()");

        allocPlayer();                                            // (1) 플레이어 객체 생성/할당 메소드 ex) 100명의 플레이어 객체 생성
        lottoManager = new LottoCardManager(players.size());      // (2) lottomanager(lottoCardManager 타입) 객체 생성
                                                                    //로또 매니저가 player.size만큼 생성되는게 아님
                                                                     //  -> 생성자에 의해 players.size() 크기의 cards 배열(lottocards 타입) 생성됨
                                                                  // ( LottoCardManager 생성자에 인자값 있으므로. player.size => playerNum으로 전달됨)
                                                                    // 결론, manager 1개 생성-> cards 100개(플레이어수) 생성 -> 각각의 cards에 number(int 6자리) 배열 1개씩 생성

        lottoManager.allocLottoCardNumber();                     // (3) 로또카드매니저 객체에 로또카드넘버 할당 메소드 적용(유효번호 체크까지)

        for (int i = 0; i < players.size(); i++) {                //(4) 플레이어마다 로또카드를 갖게함 (플레이어마다 6개 숫자 할당됨)
            players.get(i).acquireLottoCard(lottoManager, i);      //전체 흐름은 아래 players 각각 로또 번호 가지게 하는 법: 참고
        }

        winnerManager = new WinnerManager();                      //(5) 위너매니저 객체 생성 -> 생성자에 의해 winnerScoreMap 해쉬맵 생성됨
        List winner = winnerManager.sortWinner(players);           //(6) winner 점수 정렬
        winnerManager.doReward(winner);                             //(7) 보상 메소드

        return "승자 선출이 완료되었습니다!";
    }

    /** players 각각 로또 번호 가지게 하는 법:
     * 1. 플레이어 배열을 만든다. (100개)
     * 2. 로또카드매니저 1개 생성 - 카드 100개 생성 - 카드마다 번호 6개짜리 number 배열 갖게 함
     * 3. 플레이어 클래스에 로또카드 타입 변수 생성
     * 4. 플레이어 클래스에 i값 마다 로또카드를 가질 수 있게 하는 메소드 작성 (리턴값은 로또카드(가지고있는 변수)이나 파라미터로 들어오는 값은 외부에서 받는 로또카드매니저와 i 값)
     * 5. 플레이어 배열 반복문 통해 플레이어 객체에 2번 항목에서 만든 로또 카드 배열을 1개씩 할당해준다
     * 6. 결론 - players[0]- cards[0] - number(int 6) 배열 값이 연결됨
     */



    //플레이어 할당 메소드
    // players 객체 배열 생성
    //-> Max_Player(100) 만큼 players 배열에 객체 생성/할당 , 즉 players[0],,, players[99]

    private void allocPlayer() {
        players = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYER; i++) {
            players.add(new Player());
        }
    }
}