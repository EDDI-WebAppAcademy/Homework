package lbk.homework.day0817.resume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/resume")
public class ResponseResume {

    @GetMapping("/practice")
    public String responseResume() {

        return "day0817/resume";
    }
}
