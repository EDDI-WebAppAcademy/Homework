package kr.eddi.demo.controller.nineteenth;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html-controll")
public class HtmlController {

    @GetMapping("/list-tag")
    public String listTagTest() {
        log.info("list-tag");

        return "/basic/nineteenth/list-tag";
    }

    @GetMapping("/img-tag")
    public String imgTagTest() {
        log.info("img-test");

        return "/basic/nineteenth/img-tag";
    }

    @GetMapping("/font-test")
    public String fontTest() {
        log.info("font test");

        return "/basic/nineteenth/font";
    }

    @GetMapping("/color-test")
    public String colorTest() {
        log.info("color test");

        return "/basic/nineteenth/color-style";
    }

    @GetMapping("table-test1")
    public String tableTest1() {
        log.info("table test 1");

        return "/basic/nineteenth/table-test1";
    }

    @GetMapping("table-test-answer")
    public String tableTestAnwer() {
        log.info("table test answer");

        return "/basic/nineteenth/table-answer";
    }

    @GetMapping("table-test3")
    public String tableTest3() {
        log.info("table test 3");

        return "/basic/nineteenth/table-test3";
    }

    @GetMapping("table-test4")
    public String tableTest4() {
        log.info("table test 4");

        return "/basic/nineteenth/table-test4";
    }

    @GetMapping("/resume")
    public String resumeTest() {

        return "/basic/nineteenth/resume";
    }

}
