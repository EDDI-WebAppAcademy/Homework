package choijaemin.homework.controller.homework.twentieth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/20th")
public class selfIntroductionController {

    @GetMapping("/self-introduction-test")
    public String selfIntroductionTest(){
        log.info("self-introduction-test");


        return "/basic/twentieth/self-introduction-test";
    }
}
