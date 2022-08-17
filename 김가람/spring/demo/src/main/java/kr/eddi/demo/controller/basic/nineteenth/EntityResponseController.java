package kr.eddi.demo.controller.basic.nineteenth;

import kr.eddi.demo.entity.Member;
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

    // json타입의 응답
    @GetMapping("/member-response")
    public Member memberResponse() {
        Member member = new Member();

        return member;
    }

    @GetMapping("/member-list-response")
    public List<Member> memberListResponse() {
        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member();
        memberList.add(member1);

        Member member2 = new Member();
        member2.setUserName("test-account");
        memberList.add(member2);

        Member member3 = new Member();
        member3.setPassword("123456");
        memberList.add(member3);

        return memberList;
    }

    @GetMapping("member-map-response")
    public Map<String, Member> memberMapResponse() {
        Map<String, Member> memberMap = new HashMap<>();

        Member member1 = new Member();
        memberMap.put("map-test1", member1);

        Member member2 = new Member();
        member2.setUserName("test-set");
        member2.setPassword("123456");
        memberMap.put("test", member2);

        return memberMap;
    }

    @GetMapping("/no-response")
    public void noResponse() {
        log.info("no response");
    }

    // Non-RestController
    @GetMapping("/no-response2")
    public ResponseEntity<Void> noResponse2() { // Void 대신 다른 데이터 타입으로 대체 가능함.
        log.info("No Response2");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Non-RestController
    @GetMapping("/string-response")
    public ResponseEntity<String> stringResponse() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}