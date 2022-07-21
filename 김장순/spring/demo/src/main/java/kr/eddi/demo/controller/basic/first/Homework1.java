package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Homework1 {

    @GetMapping("/homework1")
    public String dice(){
        Random random = new Random();
        int result = random.nextInt(6)+1;
        return "주사위를 굴려 "+result+"이 나왔습니다.";
    }


}
