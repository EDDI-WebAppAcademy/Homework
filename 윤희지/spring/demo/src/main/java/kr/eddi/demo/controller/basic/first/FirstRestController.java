package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController vs @Controller
// 기본적으로 웹 상에서 데이터들은 json 형태로 전송됨.
// json을 보면 HashMap과 유사한 형태를 띄는 것을 볼 수 있다.
// key: value 형태로 메시지가 전달되는데 실제 json도 유사.
// {key1: value}
// value1: {key2, value2}
// {key1: {key2, value2}}
// 데이터 처리를 json을 디폴트로 처리한다는 부분이 @RestController 라고 보면 됨.
@RestController
public class FirstRestController {

    // GetMapping의 경우
    // 일반적으로 URL 입력을 통해 요청은 GET, json 데이터 전송은 POST
    // URL에 특정 주소를 입력해 사이트에 접속할 것이기 때문에 GetMapping 사용.
    @GetMapping("/")
    public String index() {
        //스프링을 사용하는 데 있어 데이터를 주고받으려면 전부 json 형태의 처리가 필요.
        return "첫번째 스프링 테스트";
    }
}
