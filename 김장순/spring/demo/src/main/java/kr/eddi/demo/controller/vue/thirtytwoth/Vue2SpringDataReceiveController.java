package kr.eddi.demo.controller.vue.thirtytwoth;

import kr.eddi.demo.controller.vue.thirtytwoth.request.VueRequestTestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/32th/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Vue2SpringDataReceiveController {

    @PostMapping("/receive-test") //post방식의 경우 데이터가 패킷안에 숨겨 전달된다(개인정보 사항 전달 시 용이). get방식은 헤더에 붙어서 전송이 된다.
    public void receiveData(@RequestBody VueRequestTestData vueRequestTestData){
        log.info("요청된 데이터 정보: " + vueRequestTestData);
    }
}
