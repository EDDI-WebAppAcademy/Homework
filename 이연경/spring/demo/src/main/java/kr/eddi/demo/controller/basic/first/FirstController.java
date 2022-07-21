package kr.eddi.demo.controller.basic.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


@Slf4j
@Controller
public class FirstController {

    @GetMapping("/Homework1")
    public String urlHomework1 (Locale locale, Model model) {

        //int ramdom=(int)(Math.random()*6)+1;
        //int number= ramdom;
        //System.out.println("주사위 번호:"+number);


        //log.info("랜덤으로 주사위 값을 출력합니다." + number);

       Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
        model.addAttribute("servTime", formattedDate);
        return "/basic/first/Homework1";



    }
}
