package kr.eddi.demo.controller.vue.thirtyfirst;

import kr.eddi.demo.entity.vue.thirtiyfirst.ExperienceExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Slf4j
@RestController
@RequestMapping("/31st/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgExperienceExchangeController {

    private static ExperienceExchange experienceExchange = new ExperienceExchange();

    @PostMapping("/exchange")
    public Boolean requestCharacterStatus (@RequestBody ArrayList<Integer> selectedExchangeList) {
        log.info("requestCharacterStatus() : " + selectedExchangeList);

        return experienceExchange.exchangeExperience(selectedExchangeList);
    }
}
