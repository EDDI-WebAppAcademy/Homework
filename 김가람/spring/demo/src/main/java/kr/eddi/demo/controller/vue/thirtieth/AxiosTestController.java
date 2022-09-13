package kr.eddi.demo.controller.vue.thirtieth;

import kr.eddi.demo.entity.vue.thirtieth.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

// 데이터 통신은 Json으로 처리 -> RequestMapping
// CrossOrigin : 통신이 가능하게 허가를 해주는 것
@Slf4j
@RestController
@RequestMapping("/30th/vue2Spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class AxiosTestController {

    @GetMapping("/test")
    public RandomNumber getVueDataTest () {
        log.info("getVueDataTest()");

        RandomNumber randomNumber = new RandomNumber();

        log.info("randomNumber: " + randomNumber);

        return randomNumber;
    }
}
