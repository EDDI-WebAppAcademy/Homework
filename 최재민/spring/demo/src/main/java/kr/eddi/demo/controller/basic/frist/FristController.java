package kr.eddi.demo.controller.basic.frist;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
public class FristController {

    @GetMapping("/What-time-is-it")
    public String whatTimeIsIt(Locale locale,Model model){
        log.info("지금 몇시냐 메서드가 동작합니다!");

        Date data = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);

        String formattedDate = dateFormat.format(data);
        model.addAttribute("servTime",formattedDate);
        return "/basic/first/whatTimeIsIt";
    }
}
