package choijaemin.homework.controller.homework.nineth;

import choijaemin.homework.entity.nineth.Card;
import choijaemin.homework.entity.nineth.Dealer;
import choijaemin.homework.entity.nineth.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/nineth")
public class PorkerGameController {

    @GetMapping("/Porker-Game")
    public void porkergame(){
        Player player = new Player();
        player.gameStart();
        // 작동 확인을 위해 작성 한코드
    }
}
