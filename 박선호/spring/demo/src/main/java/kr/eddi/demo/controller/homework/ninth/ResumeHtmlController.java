package kr.eddi.demo.controller.homework.ninth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/9th/homework")
public class ResumeHtmlController {

    @GetMapping("/resume")
    public String resume() {
        log.info("resume");

        return "/homework/ninth/resume";
    }
}
