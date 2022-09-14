package kr.eddi.demo2.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo2.entity.vue.rpg.CharacterStatus;
import kr.eddi.demo2.entity.vue.rpg.ExperienceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterController {

    @GetMapping("/character-status")
    public CharacterStatus characterStatus() {
        log.info("characterStatus()");

        CharacterStatus characterStatus = new CharacterStatus
                (1, 50, 30, 0, 10, 10, 10, 10, 10, 10, 10, 0, 10, 0, 0, "모험가" );
        return characterStatus;
    }

    @GetMapping("/exchange-shop-lists")
    public List<ExperienceManager> exchangeShopItems () {
        log.info(" exchangeShopItems ()");
        List<ExperienceManager> exchangeShopLists = new ArrayList<>();

        if (exchangeShopLists.size() == 0) {
            exchangeShopLists.add(new ExperienceManager("hp"));
            exchangeShopLists.add(new ExperienceManager("mp"));
            exchangeShopLists.add(new ExperienceManager("atk"));
            exchangeShopLists.add(new ExperienceManager("str"));
            exchangeShopLists.add(new ExperienceManager("dex"));
            exchangeShopLists.add(new ExperienceManager("int"));
            exchangeShopLists.add(new ExperienceManager("def"));
        }
        return exchangeShopLists;
    }

    @PostMapping("/exchange-exp")
    public String exchangeExp (@RequestBody RequestExchangeExp requestExchangeExp) {
        log.info("exchangeExp() - requestExchangeExp: " + requestExchangeExp);
        return "haha";
    }
}
