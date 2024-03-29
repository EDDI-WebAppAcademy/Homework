package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.entity.vue.rpg.Character;
import kr.eddi.demo.entity.vue.rpg.ExpExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game3")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterController {
    private List<ExpExchange> expTradeList = new ArrayList<>();

    @PostMapping("/character-status")
    public Character characterStatus() {
        log.info("characterStatus()");
        Character character = new Character(1, 50, 30, 0, 10, 10,
                10, 10, 10, 10, 10, 0, 10, 0, 0, "모험가");


        return character;
    }

    @GetMapping ("/exp-trade-system")
    public List<ExpExchange> viewExpTrade() {
        expTradeList = new ArrayList<>();
        log.info("viewExpTrade()");
        expTradeList.add(new ExpExchange("hp"));
        expTradeList.add(new ExpExchange("mp"));
        expTradeList.add(new ExpExchange("atk"));
        expTradeList.add(new ExpExchange("str"));
        expTradeList.add(new ExpExchange("dex"));
        expTradeList.add(new ExpExchange("int"));
        expTradeList.add(new ExpExchange("def"));


        return expTradeList;
    }
}
