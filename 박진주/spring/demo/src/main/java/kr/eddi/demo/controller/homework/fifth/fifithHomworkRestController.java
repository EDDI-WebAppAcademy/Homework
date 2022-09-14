package kr.eddi.demo.controller.homework.fifth;

import kr.eddi.demo.homework.entity.fifith.Gugudan;
import kr.eddi.demo.homework.entity.fifith.RandomString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework5")
public class fifithHomworkRestController {

    private final int num = 7;

    @GetMapping("/randomstring-upper-lower")
    public String findrandomString(){
        log.info("랜덤문자를 검색합니다.");

        RandomString randomString = new RandomString();

        return randomString.makeRandomStringCheck();
    }


    @GetMapping("/gugudan")
    public String findGugudan(){
        log.info("구구단을 검색합니다.");

        Gugudan gugudan = new Gugudan(num);

        return gugudan.makeGugudan();
    }

}

