package kr.eddi.demo.controller.basic.sixth;

import kr.eddi.demo.entity.basic.sixth.DiceGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("sixth")
public class DiceGameController1 {

    @GetMapping("/dice-game")
    public String findWinner() {
        log.info("주사위 게임을 진행중입니다.");
        DiceGame dg = new DiceGame(5); //생성자로 플레이어 인원수 제어
        dg.firstRoll(dg.getSumArr());
        dg.secondRoll(dg.getSumArr());
        /*MaxFinder mf = new MaxFinder();
        int score = mf.findMaxScore(dg.getSumArr());
        int playNum = mf.findMaxScorePlayer(dg.getSumArr()) + 1;*/

        /*score + "점으로 " + playNum + "번 플레이어 승리"*/
        return dg.getSumArr().get(0) + " " + dg.getSumArr().get(1) + " " + dg.getSumArr().get(2) + " " + dg.getSumArr().get(3) + " " +
                dg.getSumArr().get(4);
    }
}
