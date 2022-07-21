package kr.eddi.demo.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller

/* RequestMapping 은 특정 URL을 강제하는 역할을 수행한다
   ex. 게시판에는 등록(쓰기), 읽기, 수정, 삭제, 게시판 리스트 보기 등의 정보가 존재
   매번 /borad/register, /board/road/, /board/modify, /board/delete, /board/list
   RequestMapping("/board")
   register, read, modify, delete, list 등으로 각각의 제어 기능을 분리할 수 있다
   데이터 == 엔티티 (Entity) == 핵심 업무 규칙 -> JPA 까지 연결된다! (객체지향적 OOP)
 */
@RequestMapping("/second")
public class SecondController {


    // GetMapping의 괄호 안을 비워놓아도 알아서 '/' 처리를 해줌
   @GetMapping("")
    public String secondRoot(Model model) {
        log.info("두번째 루트(메인) 페이지");
        model.addAttribute("test", "3,3f");
        return "/basic/second/test";

    }

    @GetMapping("/register-test")
    public String registerTest() {
       log.info("등록(register) 테스트");

       return "/basic/second/board/register";
    }

    @GetMapping("/modify-test")
    public String modifyTest() {
       log.info("수정(modify) 테스트");

       return "/basic/second/board/modify";
    }

    @GetMapping("/delete-test")
    public String deleteTest() {
        log.info("삭제(delete) 테스트");

        return "/basic/second/board/delete";
    }

    @GetMapping("/read-test/{boradNo}")
    public String readTest(@PathVariable("boardNo") long boardNo, Model model) {
       /* PathVriable: 가변 처리를 서포트
          가변 ? boradNo 가변적인 게시물 번호
          사용자가 어떤 게시물을 읽을지 아무도 알 수 없음
          read-test/{boradNo}의 boradNo를 @PathVariable 처리하고 있음
       */
        log.info("읽기(read) 테스트 - 게시물 번호: " + boardNo);

        model.addAttribute("boradNo", boardNo);
        return "/basic/second/board/read";
    }


    @GetMapping("/list-test")
    public String listTest() {
        log.info("리스트 보기(list) 테스트");

        return "/basic/second/board/list";
    }
}
