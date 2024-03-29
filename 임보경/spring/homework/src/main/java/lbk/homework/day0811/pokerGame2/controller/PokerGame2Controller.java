package lbk.homework.day0811.pokerGame2.controller;

import lbk.homework.day0811.pokerGame2.utility.SettingCards;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/retry")
public class PokerGame2Controller {

    private PokerGame2Manager gameManagement;


    @GetMapping("start")
    public String startGame() {
        gameManagement = new PokerGame2Manager();
        gameManagement.managementDividing(); // 첫 라운드
        gameManagement.pass();
        gameManagement.managementDividing();
        gameManagement.pass();
        gameManagement.managementDividing();
        gameManagement.pass();
        gameManagement.managementDividing();
        gameManagement.pass();
        gameManagement.managementDividing();
        gameManagement.findSameCardNumber();

        return "card";
    }
}
