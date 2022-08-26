package kr.eddi.homework.controller.nineth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework9")
public class NinethLottoGameController {
    @GetMapping("/lotto-game")
    public String lottoGame(){
        log.info("lottoGame()");

        return "하하";
    }
}
