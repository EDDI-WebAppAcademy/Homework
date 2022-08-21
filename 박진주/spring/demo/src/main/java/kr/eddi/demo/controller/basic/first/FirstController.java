package kr.eddi.demo.controller.basic.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.*;

//Controller는 RestController와 다르게 json을 처리하는데 특화되지는 않음
//반면 리턴값에 html 파일 경로를 제어할 수 없음
//최근에는 RestController 사용 많이 함 - 뷰 등의 3rd party 사용 많이 하기 때문 (Controller는 소규모 등 옛날 방식)


@Slf4j
@Controller
public class FirstController {


    //Locale은 다국어 언어팩이라고 보면 됨.

        @GetMapping("/what-time-is-it")
        public String whatTimeIsIt (Locale locale, Model model){
            log.info("지금 몇시 메소드");

            Date date = new Date();
            DateFormat dateFormat = getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

            String formattedDate = dateFormat.format(date);
            //model.addAtrribute()는 HashMap처럼 특정 키값을 맵핑시키는 것이라 봐도 무방함.
            //즉, servTime에 formattedDate인 형식을 갖춘 날짜를 맵핑함
            //model.addAttribute()를 하면 HTML에서 Thymeleaf 등을 통해서 정보를 읽을 수 있음.
            model.addAttribute("servTime", formattedDate);

            //resorce/templates에 있는 basic/first/whatTimeIsIt.html를 리턴시키게 됨.
            return "/basic/first/whatTimeIsit";
        }

}
