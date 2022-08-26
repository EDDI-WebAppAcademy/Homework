package study.Project.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping
    public String secondRoot(Model model) {
        log.info("두번째 루트 페이지");

        model.addAttribute("test", 3.3f);
        return "/basic/second/test";
    }

    @GetMapping("/register-test")
    public String registerTest() {
        log.info("등록(register)테스트");

        return "basic/second/board/register";
    }

    @GetMapping("/modify-test")
    public String modifyTest() {
        log.info("수정(modify) 테스트");

        return "basic/second/board/modify";
    }

    @GetMapping("/delete-test")
    public String removeTest() {
        log.info("삭제(delete)테스트");

        return "basic/second/board/delete";
    }

    @GetMapping("/read-test/{boardNo}")
    public String readTest(@PathVariable("boardNo") long boardNo, Model model) {
        log.info("읽기(read) 테스트 - 게시물 번호: " + boardNo);

        model.addAttribute("boardNo", boardNo);
        return "basic/second/board/read";
    }

    @GetMapping("/list-test")
    public String listTest() {
        log.info("리스트 보기(list) 테스트");

        return "basic/second/board/list";
    }
}
