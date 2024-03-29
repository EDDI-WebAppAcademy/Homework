package kr.eddi.demo.controller.basic.nineteenth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html-control1")
public class HtmlController {

    @GetMapping("/list-tag")
    public String listTagTest() {
        log.info("list-tag");

        return "/basic/nineteenth/list-tag";
    }

    @GetMapping("/img-tag")
    public String imgTagTest() {
        log.info("img-tag");

        return "/basic/nineteenth/img-tag";
    }

    @GetMapping("/font-test")
    public String fontTest() {
        log.info("font-test");

        return "/basic/nineteenth/font";
    }

    @GetMapping("/color-test")
    public String colorTest() {
        log.info("color-test");

        return "/basic/nineteenth/color-style";
    }

    @GetMapping("table-test1")
    public String tableTest1() {
        log.info("table-test1");

        return "/basic/nineteenth/table-test1";
    }
}