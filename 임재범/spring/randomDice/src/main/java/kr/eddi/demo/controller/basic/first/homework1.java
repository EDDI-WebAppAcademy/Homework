package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class homework1 {

    @GetMapping("/homework1")
    public String index() {
        int num = (int) (Math.random()*6)+1;
        return "운명의 주사위 결과는 "+num+"입니다.";
    }
}