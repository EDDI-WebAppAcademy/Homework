package cls.i.hw0720.diceController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String index() {
        log.info("로컬호스트 페이지 정상인지 확인");
        return "로컬호스트 포트 3333";
    }
}
