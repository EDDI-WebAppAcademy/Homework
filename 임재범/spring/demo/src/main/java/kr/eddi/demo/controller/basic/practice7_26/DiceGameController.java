package kr.eddi.demo.controller.basic.practice7_26;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/practice7_26")
public class DiceGameController {
    @GetMapping("/letsDice")
    public String letsDice(){

        return "";
    }
}
