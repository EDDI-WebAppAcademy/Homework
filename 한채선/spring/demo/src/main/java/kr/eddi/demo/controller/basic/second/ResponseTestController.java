package kr.eddi.demo.controller.basic.second;

import kr.eddi.demo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/second/response")
public class ResponseTestController {


    /* ResponseBody: 자바 객체를 리턴할 경우 자동으로 객체를 Json 형태로 처리한다
       그로므로 Controller에서도 Json 데이터를 전송할 수 있음
       RestController를 사용할 경우 ResponseBody와 같은 기능을 사용하지 않더라도 Json 형식으로 처리해준다는 것을 기억할 것!
     */
    @ResponseBody
    @GetMapping("/member")
    public Member responseMember() {
        log.info("responseMember() 동작");

        Member member = new Member();
        member.setUserName("내 맘대로 할거야");
        member.setPassword("싫어!");
        return member;
    }
}
