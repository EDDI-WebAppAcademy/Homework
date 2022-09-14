package kr.eddi.demo.controller.basic.second;


import kr.eddi.demo.entity.basic.second.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequestMapping("/second/response")
public class ResponseTestController {

    @ResponseBody
    @GetMapping("second")

    public Member responseMember(){

        log.info("responseMember() 동작");

        Member member = new Member();
        member.setUsername("내맘대로");
        member.setPassword("싫어");


        return member;


    }
}
