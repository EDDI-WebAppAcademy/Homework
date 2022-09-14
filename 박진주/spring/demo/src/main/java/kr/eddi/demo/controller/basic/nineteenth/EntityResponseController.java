package kr.eddi.demo.controller.basic.nineteenth;

import kr.eddi.demo.entity.basic.second.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/19th")
public class EntityResponseController {

    @GetMapping("/member-response")
    public Member memberResponse(){
        Member member = new Member();

        return member;
    }


    @GetMapping("/member-list-response")
    public List<Member> memberListResponse(){
        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member();
        memberList.add(member1);

        Member member2 = new Member();
        member2.setUserName("test-account");
        memberList.add(member2);

        return  memberList;

    }

    @GetMapping("/member-map-response")
    public Map<String, Member> memberMapResponse(){
        Map<String, Member> memberMap = new HashMap<>();

        Member member1 = new Member();
        memberMap.put("map-test1", member1);

        Member member2 = new Member();
        memberMap.put("test", member2);

        return memberMap;
    }


    @GetMapping("/no-response")
    public void noResponse(){                       // 화면에 리턴값 주고 싶지 않을때 1
        log.info("no-response");
    }

    @GetMapping("/no-response2")
    public ResponseEntity<Void> noResponse2(){         //화면에 리턴값주고 싶지 않을때2-  ResponseEntity<> 는 객체형으로 <Void>, <String> 등 가능
        log.info("no-response2");

        return new ResponseEntity<>(HttpStatus.OK);               //HttpStatus.OK 는 HTTP 프로토콜 상 통신이 정상적으로 진행됨을 알려주는 항목임
    }

    @GetMapping("string-response")
    public ResponseEntity<String> stringResponse(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
