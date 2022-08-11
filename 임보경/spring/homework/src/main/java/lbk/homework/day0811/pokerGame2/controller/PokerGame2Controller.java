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

    private PokerGame2Manager prepareGameStart;


    @GetMapping("start")
    public String startGame() {
        prepareGameStart = new PokerGame2Manager();
        prepareGameStart.managementDividing();

        return "card";
    }
}
