package kr.eddi.demo.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class roll {

    @GetMapping("/homework1")
    public String homework1() {
        int num = (int)(Math.random()*6)+1;
        return "주사위 값 "+num+"이 나왔습니다!";
    }
}
