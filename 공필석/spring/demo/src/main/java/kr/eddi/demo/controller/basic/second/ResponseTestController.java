package kr.eddi.demo.controller.basic.second;

import kr.eddi.demo.entitiy.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/second/response")
public class ResponseTestController {

    // @ResponseBody - 리턴 결과를 자동으로 json 형태로 처리함
    // 그러므로 Controller 에서도 json 데이터를 전송할 수 있다.
    // @RestController 가 짱이다
    @ResponseBody
    @GetMapping("/member")
    public Member responseMember() {
        log.info("responseMember() 동작");

        Member member = new Member();
        member.setUserName("My name");
        member.setPassword("My password");

        return member;
    }
}
