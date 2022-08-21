package kr.eddi.demo.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//게시판이 있다면 등록, 읽기, 수정, 삭제, 게시판 리스트 보기 등
//매번 GetMapping하고 html쓰고 번거롭지만
//RequestMapping("/board")
//register, read, modify, delete, list 끝.
//데이터 == 엔티티(Entity) == 핵심 업무 규칙 ==> 'JPA' DB를 객체지향 관점으로 본다.
@RequestMapping("/second")
public class SecondController {

    @GetMapping("") //아무것도 안쓰면 그냥 /second만 뒤에 붙인 상태의 결과 출력
    public String secondRoot(Model model){
        log.info("두 번째 루트(메인) 페이지");

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
        //PathVariable 가변 처리를 서포트하고 있음.
        //boardNo가 가변적임.
        //사용자가 어떤 게시물을 읽을지 알 수 없기 때문에 이 기능은 필요함.
        //read-test/{boardNo}를 @PathVariable이 처리하고 있음.

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
