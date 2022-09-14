package kr.eddi.demo.controller.homework.homework13;

import kr.eddi.demo.entity.homework.thirteen.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("thirteen")
public class FruitsAdventureController {

    @GetMapping("/homework")
    public String StartAdventure(){
        log.info("FruitsAdventure 시작");
        Fruit fruit = new Fruit();
        fruit.setFruitsAbility();
        System.out.println(fruit.chooseFruits());


        return "0";
    }
}
