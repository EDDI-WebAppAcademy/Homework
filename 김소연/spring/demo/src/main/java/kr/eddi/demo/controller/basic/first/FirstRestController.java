package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController vs @Controller
// 기본적으로 웹 상에서 데이터들은 json 형태로 전송이 된다.
// json을 보면 HashMap과 유사한 형태를 띄는 것을 볼 수 있음.
// key : value 형태로 메시지가 전달되는데 실제 json도 비슷함
// {key1 : value1}
// value1: {key2 : value2}
// {key1: {key2 : value2}}
// 데이터 처리를 json을 디폴트로 처리한다라는 부분이 @RestController 라고 보면됨
// 그냥 컨트롤러로 하면 에러나 제이슨이 아니기 때문!
// 스프링은 내가 받든 주든 json으로 줘야한다는 사실!

@RestController
public class FirstRestController {

    // GetMapping의 경우
    // 실제 웹상에서 정보를 요청하는 방식엔 GET, POST가 존재함
    // 일반적으로 URL 입력을 통해 요청하는 것은 GET 방식이며
    // json 데이터를 전송하기 위한 목적으로 POST를 활용함
    // 우리는 URL에 특정 주소를 입력하여 사이트에 접속할 것이므로 GetMapping을 사용할 것임

    // / 는 루트고 루트를 요청해서 동작해서 레스트컨트롤러 결과가 json으로 되어 화면출력
    @GetMapping("/")
    public String index() {
        //결국 스프링을 사용하는데 있어
        //데이터를 주고받기 위해선 json 형태의 처리가 필요함을 알 수 있음
        return "첫번째 스프링 테스트";
    }
}
