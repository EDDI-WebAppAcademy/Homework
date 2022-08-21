package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;

public class FirstRestController {
    @GetMapping("/")
    public String Index(){
        return "첫번째 스프링 테스트";
    }
}
