package kr.eddi.demo.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class secondHomeWork {

    @GetMapping("/")
    public String dice() {
        Random random = new Random();
        int result = random.nextInt(6)+1;
        return "당신의 숫자 : "+result;

    }
}