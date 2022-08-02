package study.Project.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.Project.entity.Member;

@Slf4j
@Controller
@RequestMapping("/second/response")
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/member")
    public Member responseMember() {
        log.info("responseMember() 동작");

        Member member = new Member();

        member.setUserName("유저");
        member.setPassword("비밀번호");
        return member;
    }
}
