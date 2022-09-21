package kr.eddi.demo.controller.vue.thirtyoneth;

import kr.eddi.demo.controller.vue.requset.VueRequestTestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/32th/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Vue2SpringDataReciveController {

    @PostMapping("/receive-test")
    public void receiveData(@RequestBody VueRequestTestData vueRequestTestData){
        log.info("요청된 데이터 정보" +vueRequestTestData);
    }
}
