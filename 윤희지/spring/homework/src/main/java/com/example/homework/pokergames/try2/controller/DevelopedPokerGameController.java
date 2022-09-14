package com.example.homework.pokergames.try2.controller;

import com.example.homework.pokergames.try2.entity.PokerGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework-8-try2")

public class DevelopedPokerGameController {
    private PokerGameManager pokerGameManager;
    private final int PLAYER_NUM = 2;

    @GetMapping("/poker-game-start")
    public String pokerGameStart () {
        log.info("pokerGameStart()");


        // 1. 게임 매니저를 생성한다.
        // 2. 게임에 참여할 플레이어들을 생성한다. <- num: 2
        pokerGameManager = new PokerGameManager(PLAYER_NUM);
        System.out.println("참여 플레이어 : " + pokerGameManager.getPlayerManager().getNicknameList());
        // 3. 초기 베팅 머니를 부과한다.
        // 4. 참여 순서대로 플레이어들에게 패를 돌린다.
        // 5. 플레이어들은 공개할 패를 선택한다.
        // 6. 라운드를 시작한다.
        // 7. 가장 높은 패에게 턴 우선권을 제공한다.
        // 8. 추가패를 받는다.
        // 9. 베팅 머니 추가
        // 10. 6 ~ 9번이 반복된다 -> 추가패를 4번 받을때까지
        pokerGameManager.startGame();
        // 11. 최종 승자 판정
        //pokerGameManager.dicisionWinner();

        return "0";
    }





}
