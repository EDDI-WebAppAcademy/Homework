package kr.eddi.demo.controller.basic.twelveth;

import kr.eddi.demo.entity.basic.twelveth.PockerCard;
import kr.eddi.demo.entity.basic.twelveth.PockerGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. PockerGameController - 포커게임매니저 생성(플레이어 매니저 + 라운드 매니저) + 스타트 게임, 위너 메소드 호출
// < 엔티티 >
// 1. PockerGameManager -
// 2. RoundManager
// 3. PlayerManager
// 4. Player
// 5. PockerCard
//  -> 단순 name 관리       - (1) CardShape(문양), (2) CardCharacter(숫자), (3) Pattern (원페어, 스트레이트 등)
//  -> enum (name + value) - (4) PockerCardShape , (5) PockerCardCharacter (6) PockerCardPattern
// < 유틸리티 >
// 1. BettingMoney
// 2. UserInput


@Slf4j
@RestController
@RequestMapping("/12th")
public class PockerGameController { // URL 매니저

    private PockerGameManager pockerGameManager;
    private final int PLAYER_NUM = 2;

    @GetMapping("/pocker-game-start")
    public String pockerGameStart () {
        log.info("pockerGameStart()");

        // 1. 게임 매니저를 생성한다.
        // 2. 게임에 참여할 플레이어들을 생성한다. <- num: 2
        pockerGameManager = new PockerGameManager(PLAYER_NUM);    // (1) 포커 게임 매니저 생성
                                                                  // -> 플레이어 매니저 1개 생성(PlayerNum은 인자일뿐->갯수 아님)+라운드매니저 1개 생성
        // 3. 초기 베팅 머니를 부과한다.
        // 4. 참여 순서대로 플레이어들에게 패를 돌린다.
        // 5. 플레이어들은 공개할 패를 선택한다.
        // 6. 라운드를 시작한다.
        // 7. 가장 높은 패에게 턴 우선권을 제공한다.
        // 8. 추가패를 받는다.
        // 9. 베팅 머니 추가
        // 10. 6 ~ 9번이 반복된다 -> 추가패를 4번 받을때까지
        pockerGameManager.startGame();                                   //(2-1) 포커게임매니저 통해 startGame
        // 11. 최종 승자 판정
        pockerGameManager.dicisionWinner();                              // (3) 포커게임 매니저 통해 winner 판정

        //PockerCard pockerCard = new PockerCard();

        return "0";
    }
}