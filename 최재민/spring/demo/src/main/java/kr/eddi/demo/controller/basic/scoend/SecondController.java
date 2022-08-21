package kr.eddi.demo.controller.basic.scoend;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;


@Slf4j
@Controller
@RequestMapping("/second")
public class SecondController {

    // 비워두면 /이 가있어도 ok 없어도 ok
    @GetMapping("")
    public String secondRoot(Model model){
        log.info("두번째 루트(메인) 페이지");

        model.addAttribute("test",3.3f);
        return "/basic/second/test";
    }

    @GetMapping("/register-test")
    public String registerTest(){
        log.info("등록(register) 테스트");

        return "basic/second/board/register";
    }

    @GetMapping("/modify-test")
    public String modifyTest(){
        log.info("수정(modify)테스트");

        return "basic/second/board/modify";
    }

    @GetMapping("/delete-test")
    public String deleteTest(){
        log.info("삭제(delete)테스트");

        return "basic/second/board/delete";
    }

    @GetMapping("/read-test/{boradNo}")
    public String readTest(@PathVariable("boradNo") long boradNo, Model model){
        // PathVariable 가변 처리를 서포트하고 있음
        // 가변 ? boardNo가 가변적임
        // 사용자가 어떤 게시물을 읽을지 아무도 알 수 없으니까
        // read-test/{boradNo} 에 boradNo를 @PathVariable 이 처리하고있음
        log.info("읽기(read)테스트 - 게시물번호 : " + boradNo);

        model.addAttribute("boradNo", boradNo);
        return "basic/second/board/read";
    }

    @GetMapping("/list-test")
    public String listTest(){
        log.info("리스트 보기(list)테스트");

        return "basic/second/board/list";
    }

}
