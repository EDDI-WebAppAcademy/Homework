package kr.eddi.demo.controller.homework.homework0817;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/resume-controller")



public class resumeController {



    @GetMapping("/my-resume")

    public String resume() {
        log.info("resume-controller");

        return "/basic/myresume/resume";

    }

}
