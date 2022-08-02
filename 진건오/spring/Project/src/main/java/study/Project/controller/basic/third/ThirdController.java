package study.Project.controller.basic.third;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.Project.entity.third.ClassRoom;

@Slf4j
@RestController
@RequestMapping("/third")
public class ThirdController {

    @GetMapping("/homework")
    public float calcClassRoomMeanScore() {
        log.info("학급의 평균을 계산합니다. : calcClassRoomMeanScore");

        ClassRoom classRoom = new ClassRoom(); // ClassRoom 클래스 호출
        classRoom.setRoomName("빅데이터 반"); // 반이름 설정
        classRoom.makeRandomStudents(); // 학생수 난수로 설정 메소드 호출
        classRoom.takeTest(60); //최소 점수 설정 및 호출

        return classRoom.calcMean(); // 평균값 출력

    }
}
