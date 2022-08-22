package kr.eddi.demo.controller.twentieth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html-control")
public class HtmlController {
    @GetMapping("/example")
    public String example() {
        log.info("example");

        return "twentieth/example";
    }
}
