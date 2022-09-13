package kr.eddi.demo.controller.ten;

import kr.eddi.demo.entity.ten.PokerGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/12th")
public class PokerGameController {

    PokerGameManager pokerGameManager;
    private final int PLAYER_NUM = 2;


    @GetMapping("/pocker-game-start")
    public String pockerGameStart() {
     /*   log.info("pokerGameStart");

            //1. 게임매니저를 생성
        pokerGameManager = new PokerGameManager(PLAYER_NUM);
            //2. 게임에 참여할 플레이어들을 생성 (최소 2명)
            //3. 초기 배팅머니를 부과한다.
            //4. 참여 순서대로 플레이어들에게 패를 돌린다
            //5. 플레이어들이 공개할 패를 선택한다
            //6. 라운드를 시작한다.
            //7. 가장 높은 패에게 턴 우선권을 제공한다.
            //8. 추가 패를 받는다.
            //9. 배팅 머니 추가
            //10. 6~9번 반복 (추가 패를 4번 받을 때까지
        pokerGameManager.startGame();
            //11. 최종 승자 판정정
        pokerGameManager.decisionWinner();

*/
        return null;
    }
}
