package lbk.homework.day0902.vue;

import lbk.homework.day0902.vue.entity.RandomNumber;
import lbk.homework.day0902.vue.entity.RpgPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lbk.homework.day0728.strangeLotto.utility.CustomRandom.makeCustomRandom;


@Slf4j
@RestController
@RequestMapping("/30th/vue2spring")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders = "*")
public class AxiosTestController {

    @ResponseBody
    @GetMapping("/test")
    public RandomNumber getVueDataTest () {


//        log.info("randomNumber: " + randomNumber);
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber;
    }


    @GetMapping("/test2")
    public RpgPlayer getVueDataTest2() {
        RpgPlayer player = new RpgPlayer();

        return player;
    }

}
