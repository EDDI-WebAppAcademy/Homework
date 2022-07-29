package kr.eddi.demo.controller.homework.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.entity.homework.seventh.Participant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework7")
public class LottoSystemRestController {
    private final int DEFAULT_PP_NUM = 100; // 디폴트 참여 인원 설정
    private int ppNum; // 참여자수
    private List<Participant> participants;

    @GetMapping("/run-lotto-system")
    public String RunLottoSystem() {

        creatParticipant(); // 100명의 참가자 생성 완료.
        runSystem(); // 시스템 실행
        // 우승자 확인


        return "결과값";
    }

    //참여자 생성
    public void creatParticipant() {

        participants = new ArrayList<>();
        this.ppNum = DEFAULT_PP_NUM;

        createParticipantObj(participants, DEFAULT_PP_NUM);

    }

    public void createParticipantObj(List<Participant> participants, int ppObjNum) {
        for (int i = 0; i < ppObjNum; i++) {
            participants.add(new Participant());
        }
    }

    public void runSystem() {
        for (int i = 0; i < ppNum; i++) {
            // 각 플레이어가 게임 실행하는 기능
            participants.get(i).runSystem(participants, i);
        }

    }
}
