package kr.eddi.demo.controller.homework.seventh_fix;

import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import kr.eddi.demo.homework.entity.seventh_fix.LottoNumManager1;
import kr.eddi.demo.homework.entity.seventh_fix.LottoPlayer1;
import kr.eddi.demo.homework.entity.seventh_fix.LottoScore1;

import kr.eddi.demo.homework.utility.seventh_fix.LottoNum1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework7")
public class SeventhLottoSystemController1 {

    // 로또게임 과제 1차 작성에서는 같은 자리 중복번호 유효체크 메소드 구현 못함 (그 외 로또번호 추첨 기능 및 결과출력 동작 완료)
    // 강사님 코드 리뷰 후 수정한 코드 (seventh_fix 폴더)
    // -> LottNumManager 클래스를 추가함.(컨트롤러 시작 시점에서 객체 생성 방식을 동일하게 수정)
    // 중복번호 유효체크 메소드를 동일하게 수정
    // 그 외 다른 점은 winnerManager 클래스는 별도로 두지 않았고, player 숫자는 랜덤하게 구성
    // 배운 점은 객체 생성자를 통한 클래스의 정보 연동, 메소드 인자 사용(어떤 인자를 받아 메소드 구현해야하는지), getter setter 등의 개념을 어느정도 깨닫게 됨
    // 유틸리티로 사용하려면 언제든 호출 가능하도록 구성해야 하므로 보통 static으로 구현한다고 함


    private final int MAX_PLAYER_NUM = 100;  // 최대 100명 -> min, max로 참가자 수 랜덤으로 만들기

    private final int MIN_PLAYER_NUM = 2;

    private List<LottoPlayer1> players;

    private LottoNumManager1 lottoNumManager1;
    private List<LottoNum1> lottoNums1;

    private int playerNum;

    private int winnerIdx;
    private final int reward = 100;

    private int finalReward;

    @GetMapping("/lotto-system2")
    public String lottoSystemStarter() {

        createPlayer();       // 플레이어 100명

        lottoNumManager1 = new LottoNumManager1(playerNum);
        lottoNumManager1.allocLottoNum(); // 로또 넘버 객체 배열마다 넘버 부여+ 유효 체크 -> 로또 넘버 객체 배열 값 할당됨


        for (int i = 0; i < players.size(); i++) {                //(4) 플레이어마다 로또카드를 갖게함 (플레이어마다 6개 숫자 할당됨)
            players.get(i).acquireLottoNums(lottoNumManager1, i);      //전체 흐름은 아래 players 각각 로또 번호 가지게 하는 법: 참고
        }


        return checkWinner(players);
    }

    public void createPlayer() {
        players = new ArrayList<>();
        this.playerNum = CustomRandom.makeIntCustomRandom(MIN_PLAYER_NUM, MAX_PLAYER_NUM);

        createPlayerObj(players, this.playerNum);  // 생성한 플레이어 객체 정보, 플레이어 참가자수
    }


    public void createPlayerObj(List<LottoPlayer1> players, int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new LottoPlayer1());
        }
    }

    public String checkWinner(List<LottoPlayer1> players) {

        LottoScore1.ScoreCalculation(players);        // 플레이어별 스코어 계산 -> LottoScore1.totalScore[] 배열 생성됨

        log.info( "플레이어 닉네임" + players +"플레이어 점수"+ Arrays.toString(LottoScore1.getTotalScore()));


       return CalcReward(calMaxPlayerScore());

    }

    public int calMaxPlayerScore(){

        int maxPlayerScore = LottoScore1.getTotalScore()[0];

        for (int i = 1; i < players.size(); i++) {
            if (LottoScore1.getTotalScore()[i] > maxPlayerScore) {
                maxPlayerScore = LottoScore1.getTotalScore()[i];
                winnerIdx = i;
            }
        }
        return maxPlayerScore;
    }


    public String CalcReward(int maxPlayerScore){

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = players.size() - 2; i >= 0; i--) {          // i 시작값이 playerNum-2 인 이유는 본인 제외하고 비교해야 해서
            int tmpScore = LottoScore1.getTotalScore()[i];

            if(winnerIdx == i){         // 만약 맥스플레이어 값을 가진 사람이 i와 같지 않은 경우 실행
                break;
            } else {
                if (maxPlayerScore == tmpScore) {              // 동일 최종 점수가 있다면  sameScor배열에 i인덱스를 넣어라
                    sameScoreIdxList.add(i);
                }else{
                    finalReward = reward;           // 동일 최종 점수가 없다면 finalReward 값을 100억 고정해라
                    break;
                }
            }
        }

        if (sameScoreIdxList.size() > 0) {
            finalReward = reward / (sameScoreIdxList.size() + 1);     // 동일한 최종점수 있으면 그만큼 상금 나누기 sameScoreIdxList.size()= 동일한 점수 있으면 1개 추가되기 때문에 사람명수를 구하려고 +1 함
            return "무승부입니다." + (sameScoreIdxList.size() + 1) + "의 참가자가 상금을" + finalReward + "억원씩 나눠갖습니다.";
        }
        log.info("승자 메소드 실행");
        return "플레이어: " + players.get(winnerIdx).getNickName() + " 님이 " + maxPlayerScore + "점으로 승리했습니다! 상금은" + finalReward + "억입니다.";

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

