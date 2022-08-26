package kr.eddi.demo2.controller.basic.third;

import kr.eddi.demo2.entity.third.ClassRoom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/third")
public class ThirdRestController {

    @GetMapping("/homework")
    public float calcClassRoomMeanScore(){
        log.info("학급의 평균을 계산합니다: calcClassRoomMeanScore()");

        ClassRoom classRoom = new ClassRoom();
        classRoom.setRoomName("빅데이터 반");
        //학생수구하기 -ClassRoom
        classRoom.makeRandomStudents();
        classRoom.takeTest(60);

        return classRoom.clacMean();
    }
}
