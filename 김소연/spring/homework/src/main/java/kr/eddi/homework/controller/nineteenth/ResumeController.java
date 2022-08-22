package kr.eddi.homework.controller.nineteenth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/homework")
public class ResumeController {
    @GetMapping("resume")
    public String resume(){
        log.info("resume");

        return "/basic/nineteenth/resume";
    }
}
