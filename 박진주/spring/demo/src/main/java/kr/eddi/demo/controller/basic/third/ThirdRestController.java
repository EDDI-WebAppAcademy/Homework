package kr.eddi.demo.controller.basic.third;


import kr.eddi.demo.entity.basic.third.ClassRoom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/third")
public class ThirdRestController {


    @GetMapping("/homework")
    public float calcClassRoomMeanScore() {
        log.info("학급의 평균을 계산합니다: calcClassRoomMeanScore()");

        ClassRoom classRoom = new ClassRoom();     // 인스턴스 생성
        classRoom.setRoomName("빅데이터 반");        // 빅데이터반으로 클래스네임 셋팅해줌
        classRoom.makeRandomStudents();            // 시
        classRoom.takeTest(60);                // 시험 메소드

        return classRoom.calcMean();                // 학급 계산 평균 리턴
    }

}

//4. 반 학생이 30명이 있다.
//   이들은 모두 시험을 치뤘고 모든 학생들은 60점 미만이 없다고 한다.
//   이 상태에서 학생들의 점수를 임의로 배치하고
//   학급의 평균값을 구해보도록 한다.
//[출처] 문제 은행 [ 3 ] (에디로봇아카데미) | 작성자 링크쌤
