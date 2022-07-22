package kr.eddi.demo.controller.homework.first;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DiceController {

    @GetMapping("/homework1")

    public String DiceRollingTest(){

        Random random = new Random();
        int num = random.nextInt(6)+1;

        return " ▶▶▶ 주사위를 굴려 " + num + " 이 나왔습니다. ◀◀◀";
    }

}