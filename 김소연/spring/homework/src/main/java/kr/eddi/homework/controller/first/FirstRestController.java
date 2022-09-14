package kr.eddi.homework.controller.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    //수업설명
    //*Controller
    //Controller 는 RestController 와 다르게 json을 처리하는데 특화
    //반면 리턴값에 html 파일 경로를 제어할 수 있음
    //요즘은 RestController 써

    /*Locale은 다국어 언어팩이라고 보면됨
    * model.addAttribute() 는 HashMap처럼 특정 키값이 벨류값을 맵핑시키는 것이라 봐도 무방
    * model.addAttribute()를 하면 HTML에서서 Thmeleaf 등을 통해서 정보를 읽을 수 있다.
    * 첫 수업에선 resource/templates에 있는 basic/first/whatTimeIsIt.html을 리턴시키게 됨
    * thymeleaf 형태의 test출력 : model.addAttribute()에서 맵핑된 servTime을 출력하라고 하니
    * 앞서 formattedDate
    *
    * */


    @GetMapping("/")
    public String index(){
        return "첫번째 스프링 테스트";
    }
}
