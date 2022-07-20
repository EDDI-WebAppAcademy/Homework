package cls.i.hw0720.diceController;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class DiceController {

    ///homework1 URL을 요청하면
    //주사위를 굴려서 주사위 값을 화면에 출력되게 만들어보자!
    // port: 3333

    @GetMapping("/homework1")
    public String randomDice() {
        log.info("랜덤 다이스 메소드를 사용합니다.");
        int diceNum = new Random().nextInt(6) + 1;
        return String.format("주사위를 굴렸습니다. 숫자 %d이/가 나왔습니다.", diceNum);
    }
}