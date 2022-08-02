package kr.eddi.demo.controller.homework.sixth;

import kr.eddi.demo.homeworkEntity.sixth.GameResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework6")
public class sixthHomeworkController {

    @GetMapping("/dicegame-n")
    public String playDiceGame(){
        log.info("N명 주사위 게임 실행합니다.");

        GameResult gameResult = new GameResult();

        return gameResult.findDiceGameWinner();//우승자 결과 값
    }


}


