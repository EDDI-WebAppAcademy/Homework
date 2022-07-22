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

<<<<<<< HEAD
// controller 는 RestController와 다르게 json을 처리하는데 특화x
// 반면 리턴값에 html 파일 경로를 제어할 수 있음.

=======
>>>>>>> origin/main
@Slf4j
@Controller
public class FristController {

<<<<<<< HEAD
    // Locale은 다국어 언어팩이라고 보면됨.
=======
>>>>>>> origin/main
    @GetMapping("/What-time-is-it")
    public String whatTimeIsIt(Locale locale,Model model){
        log.info("지금 몇시냐 메서드가 동작합니다!");

        Date data = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);

        String formattedDate = dateFormat.format(data);
<<<<<<< HEAD
        // model.addAttribute() 는 HashMao 처럼 특정 키값이 벨류값을 맵핑시키는 것이라 봐도 무방함.
        // 즉 servTime에 formattedDate 인 형식을 갖춘 날자가 맵핌됨.
        // model.addAttribute()을 하면 HTMl 에서 thymeleaf 등을 통해서 정보를 읽을 수 있음.
        model.addAttribute("servTime",formattedDate);
        // resource/template 에 있는 basic/first/whatTimeIsIt.html 을 리턴시킴.
=======
        model.addAttribute("servTime",formattedDate);
>>>>>>> origin/main
        return "/basic/first/whatTimeIsIt";
    }
}
