package kr.eddi.demo.controller.basic.Question;

import kr.eddi.demo.entity.basic.practiceQuestion.SchoolBellRings;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/18th")
public class ring {

    @GetMapping("/SchoolRingBell")
    public void Sing(){
        SchoolBellRings schoolBellRings = new SchoolBellRings();
    }
}
