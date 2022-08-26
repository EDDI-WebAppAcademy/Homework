package kr.eddi.demo.controller.homework.nineteenth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/homework19")
public class ResumeController {

    @GetMapping("/my-resume")
    public String myResume() {
        log.info("my-resume");

        return "/homework/resume";
    }
}
