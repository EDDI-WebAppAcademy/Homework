package kr.eddi.demo.controller.homework.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import kr.eddi.demo.homeworkEntity.seventh.LottoPlayer;
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
public class SeventhLottoSystemController {

    private final int MAX_PLAYER_NUM = 100;  // 최대 100명 -> min, max로 참가자 수 랜덤으로 만들기

    private final int MIN_PLAYER_NUM = 2;

    private List<LottoPlayer> players;

    private int playerNum;

    private final int reward = 100;

    private int finalReward;

    @GetMapping("/lotto-system")
    public String lottoSystemStarter() {

        createPlayer();
        gameStart();

        return checkWinner();

    }

    public void createPlayer(){
       players = new ArrayList<>();
       this.playerNum = CustomRandom.makeIntCustomRandom(MIN_PLAYER_NUM, MAX_PLAYER_NUM);

        createPlayerObj(players, this.playerNum);  // 생성한 플레이어 객체 정보, 플레이어 참가자수
    }


    public void createPlayerObj(List<LottoPlayer> players, int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new LottoPlayer());
        }
    }


    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).gameStart(players);
        }
    }

    public String checkWinner() {

        log.info("정렬전: " + String.valueOf(players));

        Collections.sort(players);

        log.info("정렬후: " + String.valueOf(players));

        int maxPlayerScore = acquirePlayerTotalScore(playerNum - 1);

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = playerNum - 2; i >= 0; i--) {          // i 시작값이 playerNum-2 인 이유는 본인 제외하고 비교해야 해서
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore) {               // 동일 최종 점수가 있는 지 비교
                finalReward = reward;
                break;
            }
            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 0) {
            finalReward = reward/(sameScoreIdxList.size()+1);     // 동일한 최종점수 있으면 그만큼 상금 나누기 sameScoreIdxList.size()= 동일한 점수 있으면 1개 추가되기 때문에 사람명수를 구하려고 +1 함
            return "무승부입니다." +(sameScoreIdxList.size()+1)+"의 참가자가 상금을" + finalReward +"억원씩 나눠갖습니다.";
        }

        return "플레이어: " + players.get(playerNum - 1).getNickName() + " 님이 "+ players.get(playerNum - 1).getScore().getTotalScore()+"점으로 승리했습니다! 상금은" +finalReward+"억입니다.";

    }


    public int acquirePlayerTotalScore(int idx) {
        return players.get(idx).getScore().getTotalScore();
    }

}



//굉장히 특수한 규칙을 가진 로또 시스템을 만들어봅시다.
//로또 번호는 총 6가지로 각각의 숫자를 랜덤으로 생성해줍니다.
//추가적으로 사용자에게 이름(별명)을 부여해주도록 합니다.
//우승자 발표 이후 목숨을 보장할 수 없으므로 별명을 사용하도록 합니다.
//
//해당 로또의 참여 인원 제한은 100명입니다.
//로또 우승자 선별 방식은 아래와 같습니다.
//[ (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6 이 가장 큰 사람이 우승자가 됩니다.
//상금은 100억이고 동점자가 있다면 동점자만큼 분할해서 가져갑니다.
//이것을 오늘 학습한 사항을 토대로 설계해봅시다.
//(숫자는 0 ~ 99까지 총 100개의 난수를 생성합니다)
//
//추가적으로 숫자는 아래와 같이 이미 배정된 숫자라면 중복 할당되지 않도록 배치합니다.
//(같은 숫자, 같은 위치는 안된다는 뜻)
//예1) 사람1: 99-00-11-23-45-67, 사람2: 99-01-22-67-45-21 <<< 맨 앞 99에서 문제
//예2) 사람1: 11-22-33-44-55-66, 사람2: 66-55-44-33-22-11 <<< 문제 없음
//[출처] Collections 문제 [ 1 ] (에디로봇아카데미) | 작성자 링크쌤