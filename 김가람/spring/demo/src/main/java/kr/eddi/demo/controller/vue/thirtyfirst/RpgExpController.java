package kr.eddi.demo.controller.vue.thirtyfirst;

import kr.eddi.demo.entity.vue.thirtiyfirst.ExpExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31st/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgExpController {
    List<ExpExchange> expExchangeList = new ArrayList<>();

    @GetMapping("/view-exp-exchange")
    public List<ExpExchange> viewExpExchange () {
        log.info("viewExpExchange()");

        if(expExchangeList.size() == 0) {
            expExchangeList.add(new ExpExchange("HP"));
            expExchangeList.add(new ExpExchange("MP"));
            expExchangeList.add(new ExpExchange("ATK"));
            expExchangeList.add(new ExpExchange("STR"));
            expExchangeList.add(new ExpExchange("DEX"));
            expExchangeList.add(new ExpExchange("INT"));
            expExchangeList.add(new ExpExchange("DEF"));
        }

        return expExchangeList;
    }
}
