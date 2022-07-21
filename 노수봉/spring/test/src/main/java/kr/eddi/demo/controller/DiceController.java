package kr.eddi.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/Homework1")
    public String Dice (){
        int Dice = (int)((Math.random() * 6) + 1);
        return "주사위 수 : " + Dice;
    }


}
