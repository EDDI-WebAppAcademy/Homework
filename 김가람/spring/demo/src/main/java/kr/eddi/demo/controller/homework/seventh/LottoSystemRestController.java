package kr.eddi.demo.controller.homework.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.entity.homework.seventh.Participant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework7")
public class LottoSystemRestController {
    private final int DEFAULT_PP_NUM = 100; // 디폴트 참여 인원 설정
    private int ppNum; // 참여자수
    private List<Participant> participants;
    private List<Integer> findWinnerList;
    private long defaultPrize = 10000000000L;
    ;

    @GetMapping("/run-lotto-system")
    public String RunLottoSystem() {

        creatParticipant();
        runSystem();
        return checkWinner();
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

    public String checkWinner() {
        int winnerNum = findWinner();
        long prize = calcPrize();
        return "로또 당첨자는 총 " + winnerNum + "명" + "<br>상금은 " + prize + "원 입니다.";
    }

    public long calcPrize() {
        long prize = 0L;
        if (findWinnerList.size() == 1) {
            prize = defaultPrize;
        } else if (findWinnerList.size() > 1) {
            prize = defaultPrize / findWinnerList.size();
        }
        return prize;
    }

    public int findWinner() { // 동점자 찾기
        log.info("정렬 전: " + String.valueOf(participants));

        Collections.sort(participants);

        log.info("정렬 후: " + String.valueOf(participants));

        findWinnerList = new ArrayList<>();

        int maxLottoScore = acquireTotalLottoScore(DEFAULT_PP_NUM - 1);
        int winnerNum = 0;
        for (int i = 0; i < DEFAULT_PP_NUM - 2; i++) {
            int tmpLottoScore = acquireTotalLottoScore(i);
            if (maxLottoScore == tmpLottoScore) {
                findWinnerList.add(i);
            }
            winnerNum = findWinnerList.size();
        }
        return winnerNum;
    }

    public int acquireTotalLottoScore(int idx) {
        return participants.get(idx).getLottoScore().getTotalLottoScore();
    }
}
