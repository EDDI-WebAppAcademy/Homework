package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/* @RestController vs @Controller
   기본적으로 웹 상에서 데이터들은 json 형태로 전송이 된다
   Json 은 Hashmap 과 유사한 형태를 띄는 것을 볼 수 있음
   key : value 형태로 메시지가 전달되는데 실제 json도 비슷하다
   {key1: value1}
   value1 : {key2, value2}
   {key1: {key2, value2}}
   데이터 처리를 json을 디폴트로 처리한다는 부분이 @RestController
*/
@RestController
public class FirstRestController {

    /* GetMapping
     실제 웹상에서 정보를 요청하는 방식인 GET, POST 가 존재
     일반적으로 URL입력을 통해 요청하는 것은 GET방식
     JSON데이터를 전송하기 위한 목적으로 POST를 활용
     우리는 URL에 특정 주소를 입력하여 사이트에 접속하므로 GetMapping을 사용
   */

    @GetMapping("/")
    public String index() {
        return "첫번째 스프링 테스트";
    }
}
