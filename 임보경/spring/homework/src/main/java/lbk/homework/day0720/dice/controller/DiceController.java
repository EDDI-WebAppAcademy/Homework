package lbk.homework.day0720.dice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

// Controller는 RestController 와 다르게 json을 처리하는데 특화되지는 않음.
// 반면 리턴값에 html 파일 경로를 제어할 수 있음.
// 프론트엔드 프레임워크(vue, react etc...)를 사용하면 RestController를 사용함.
// 검색엔진이 어렵니다. seu

// Locale은 다국어 언어팩이라고 보면 됨
// model.addAttribute()는 HashMap처럼 특정 키값이 밸류값을 맵핑시키는 것이라 봐도 무방함.
// 즉 servTime에 formattedDate인 형식을 갖춘 날짜가 맵핑됨
// model.addAttribute()를 하면 HTML에서 Thymeleaf(싸임리프) 등을 통해서 정보를 읽을 수 있음.
// Thymeleaf도 프레임워크같은거라고 생각하면 생각함.
// return 경로 >  resources/templates에 있는 해당 경로의 html을 리턴시키게 됨.

// html th:text = "${ servTime }" 가 thymeleaf 형태
@Slf4j
@RestController
public class DiceController {

    @GetMapping("/homework1")
    public String randomDice() {
        log.info("랜덤 다이스 메소드를 사용합니다.");
        int diceNum = new Random().nextInt(6) + 1;
        return String.format("주사위를 굴렸습니다. 숫자 %d이/가 나왔습니다.", diceNum);
    }
}
