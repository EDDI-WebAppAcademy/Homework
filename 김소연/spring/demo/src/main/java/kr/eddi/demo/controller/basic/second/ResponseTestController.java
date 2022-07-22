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


    //데이터가 나오려면? json으로
    //@ResponseBody 리턴 결과를 자동으로 json 형태로 처리한다
    //그러므로 Controller에서도 json 데이터를 전송할 수 있다.
    @ResponseBody
    @GetMapping("/member")
    public Member responseMember(){
        log.info("responseMember() 동작");

        Member member = new Member();

        //이것도 됨
        //멤버에 세터게터 안만들었는데 되는이유?
        //롬복의 @Getter @Setter 있어서 그래

       member.setUserName("내맘대로할거야");
        member.setPassword("싫어!!!");

        return member;
        //return member;은 에러 json을 넘겨야하는데 형태가 아님
        //마법의 키워드 작성 @ResponseBody
    }
}
