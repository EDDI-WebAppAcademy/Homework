package kr.eddi.homework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class homework2 {

    @GetMapping("/randomdice")
    public String dice(){
        int ran = (int)(Math.random()*6)+1;
        return "주사위의 숫자는 : " + ran + "이가 나왔습니다";
    }
}