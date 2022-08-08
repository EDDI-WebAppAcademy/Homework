package choijaemin.homework.controller.homework.nineth;

import choijaemin.homework.entity.nineth.PockerGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/nineth")
public class PorkerGameController {
    private final int Player_NUM = 2;


    @GetMapping("/Porker-Game")
    public void porkergame(){

        // 게임 매니져를 생성한다
        PockerGameManager pockerGameManager = new PockerGameManager(Player_NUM);

        pockerGameManager.gameStart();

        pockerGameManager.checkWinner();


    }
}
