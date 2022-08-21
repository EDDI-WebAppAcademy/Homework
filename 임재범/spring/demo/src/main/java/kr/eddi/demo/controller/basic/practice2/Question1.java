package kr.eddi.demo.controller.basic.practice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.utility.basic.third.CustomRandom;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question1 {
    //최종적으로 65~122사이의 랜덤한 문자를 리턴해야함. 단, 그 숫자는 65이상 90이하 or 97이상 122이하를 만족하는 수여야함.
    @GetMapping("/1")
    public char lowerOrUpper() {
        CustomRandom rand = new CustomRandom();
        int num = rand.makeIntCustomRandom(65, 122);
        while(num>=91 && num<=96){
            num = rand.makeIntCustomRandom(65, 122);
        }

        char ch = (char) num;

      return ch;

    }
    }

