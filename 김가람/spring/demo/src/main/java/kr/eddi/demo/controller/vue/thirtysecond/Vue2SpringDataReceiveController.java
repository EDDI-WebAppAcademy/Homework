package kr.eddi.demo.controller.vue.thirtysecond;

import kr.eddi.demo.controller.vue.thirtysecond.request.VueRequestTestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/32nd/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Vue2SpringDataReceiveController {

    @PostMapping("/receive-test")
    // 데이터 전달받을 때는 @RequestBody를 사용함
    public void receiveData (@RequestBody VueRequestTestData vueRequestTestData) {
        log.info("요청된 데이터 정보: " + vueRequestTestData);

    }
}
