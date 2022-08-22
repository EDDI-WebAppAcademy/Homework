package kr.eddi.demo.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
// RequestMapping은 특정 URL을 강제하는 역할 수행
// 게시판을 예로 들면 등록(쓰기), 읽기, 수정, 삭제, 게시판 리스트 보기
// 매번 /board/register, /board/read 등등 써야하는데
// RequestMapping("/board") 쓰면
// register, read, modify, delete, list만 쓰면 됨(매번 /board 안써도 됨)
// 데이터 == 엔티티(Entity) == 핵심 업무 규칙 -> JPA까지 연결된다
@RequestMapping("/second")
public class SecondController {

    // 그냥 비워놓으면 알아서 '/' 처리와 그냥 안붙은 처리를 하게 됨
    @GetMapping("")
    public String secondRoot (Model model) {
        log.info("두번째 루트(메인) 페이지");

        model.addAttribute("test", 3.3f);
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
    public String removeTest() {
        log.info("삭제(delete) 테스트");

        return "/basic/second/board/delete";
    }

    @GetMapping("/read-test/{boardNo}")
    public String readTest(@PathVariable("boardNo") long boardNo, Model model) {
        // PathVariable 가변 처리를 서포트하고 있음
        // boardNo가 가변적임
        // 사용자가 어떤 게시물을 읽을지 알 수 없음
        // read-test/{boardNo} 에 boardNo를 @PathVariable이 처리하고 있음
        log.info("읽기(read) 테스트 - 게시물 번호: " + boardNo);

        model.addAttribute("boardNo", boardNo);
        return "/basic/second/board/read";
    }

    @GetMapping("/list-test")
    public String listTest() {
        log.info("리스트 보기(list) 테스트");

        return "/basic/second/board/list";
    }
}
