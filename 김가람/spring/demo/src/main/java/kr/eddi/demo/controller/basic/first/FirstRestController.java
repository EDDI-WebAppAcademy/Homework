package kr.eddi.demo.controller.basic.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// {key1 : {key2, value2}}
// 데이터 처리를 json을 디폴트로 처리한다는 부분이 @RestController 라고 보면 됨.
    @RestController
    public class FirstRestController {
        public class FirstController {

            // GetMapping의 경우
            // 실제 웹상에서 정보를 요청하는 방식엔 GET, POST가 존재함
            // 일반적으로 URL 입력을 통해 요청하는 것은 GET 방식이며
            // json 데이터를 전송하기 위한 목적으로 POST를 활용함.
            // 우리는 URL이 특정 주소를 입력하여 사이트에 접속할 것이므로 GetMapping을 사용한 것임.
            @GetMapping("/")
            public String index() {
                // 여기서 얻어지는 결론은
                // 결국 스프링을 사용하는데 있어
                // 데이터를 주고 받기 위해선 전부 json 형태의 처리가 필요함을 알 수 있음.
                return "첫번째 스프링 테스트";
            }
        }
}
