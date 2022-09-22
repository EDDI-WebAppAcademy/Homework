package kr.eddi.demo.controller.tenth;

import kr.eddi.demo.entity.tenth.PokerCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tenth-homework")
public class PokerGameRestController {

    @GetMapping("/poker")
    public List<String[]> pokerGame() {
        log.info("플레이어와 컴퓨터에게 카드 7장씩 분배합니다.");

        PokerCard pokerCard = new PokerCard();
        pokerCard.pokerCardsDeal();




        return pokerCard.pokerCardsDeal();
    }
}
