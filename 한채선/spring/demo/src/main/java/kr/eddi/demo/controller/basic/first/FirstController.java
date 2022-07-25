package kr.eddi.demo.controller.basic.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


/* Controller는 RestController와 다르게 Json을 처리하는데 특화어있지는 않다 (옛 방식)
   반면 리턴값에 html파일 경로를 제어할 수 있다
   외부 데이터를 많이 불러와야 하는 규모가 큰 웹사이트는 대체로 RestController를 사용하는 추세
   프론트 프레임워크를 따로 사용해야하는 경우도 RestController를 사용한다 (ex. Vue, React)
 */

@Slf4j
@Controller
public class FirstController {

    /* Locale : 다국적 언어팩

     */
    @GetMapping("/what-time-is-it")
    public String whatTimeIsIt(Locale locale, Model model) {
        log.info("지금 몇시냐 메소드가 동작합니다!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
        /* model.addAttribute() : HashMap처럼 특정 key값이 value 값을 맵핑시키는 메소드
           이하의 소스코드에서는 servTime 이라는 key에 formattedDate인 형식을 갖춘 날짜가 mapping 된다
           model.addAttribute() 를 통해 HTML에서 Thymeleaf(HTML에서 UI를 서포트하는 라이브러리) 등을 통해서 정보를 읽을 수 있음음
        */
        model.addAttribute("servTime", formattedDate);

        //resources/tamplates 에 있는 basic/first/swhatTimeIsIt.html을 리턴
        return "/basic/first/whatTimeIsIt";
    }
}
