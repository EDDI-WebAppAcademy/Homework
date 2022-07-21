package kr.eddi.demo.controller.basic.first;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class homework1 {

    @GetMapping("/homework1")

    public String Dice(){

        Random random = new Random();
        int num = random.nextInt(6)+1;

        return "주사위" + num + "";
    }

}