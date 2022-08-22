package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/homework1")
    public String dice(){
        log.info("주사위 값을 반환하는 메서드가 동작합니다.");
        Random ran = new Random();
        int ranNum = ran.nextInt(6) + 1;
        return String.format("주사위 값 : %d",ranNum);
    }
}
