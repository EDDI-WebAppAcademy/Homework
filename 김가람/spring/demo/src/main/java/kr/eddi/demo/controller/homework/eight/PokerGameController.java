package kr.eddi.demo.controller.homework.eight;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework8")
public class PokerGameController {

    @GetMapping("/poker-game")
    public void playPokerGame() {

    }
}
