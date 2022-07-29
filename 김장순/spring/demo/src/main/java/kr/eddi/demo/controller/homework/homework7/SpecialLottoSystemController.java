package kr.eddi.demo.controller.homework.homework7;

import kr.eddi.demo.entity.basic.sixth.clean.Player;
import kr.eddi.demo.entity.basic.sixth.clean.Score;
import kr.eddi.demo.entity.homework.seventh.LottoScore;
import kr.eddi.demo.entity.homework.seventh.Participant;
import kr.eddi.demo.utility.homework.seventh.CustomLotto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("seventh")
public class SpecialLottoSystemController {
    private List<Integer> participants;
    private final int DEFAULT_PARTICIPANTS_NUM = 1;
    private final int MAX_PARTICIPANTS_NUM = 100;
    private Participant[] parti;
    private int partiNum;

    @GetMapping("/homework/lotto")
    public String showL() {
        createParticipants();
        parti[0].runSystem(parti);

        return checkWinner();
    }

    public void createParticipants() {
        parti = new Participant[DEFAULT_PARTICIPANTS_NUM];
        this.partiNum = DEFAULT_PARTICIPANTS_NUM;

        createParticipantsObj(parti, DEFAULT_PARTICIPANTS_NUM);
    }

    public void createParticipantsObj(Participant parti[], int partiNum) {
        for (int i = 0; i < partiNum; i++) {
            parti[i] = new Participant();
        }
    }

    public List<Integer> simplyShow(List<List<Integer>> comparedLotto, int num) {

        List<Integer> compareOne = comparedLotto.get(num);
        return compareOne;
    }

    public String checkWinner() {
        int unknown1 = parti[0].getLscore().getScoreList().get(0);
        int unknown2 = parti[0].getLscore().getScoreList().get(1);

        if (unknown1 > unknown2) {
            return "unknown1 " + unknown1 + "점으로 우승!";
        } else if (unknown1 < unknown2) {
            return "unknown2 "+unknown2+ "점으로 우승!";
        } else {
            return "무승부";
        }
    }
}
