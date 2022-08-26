package kr.eddi.demo.homeworkEntity.seventh;

import kr.eddi.demo.homeworkEntity.utility.basic.seventh.LottoNum;
import kr.eddi.demo.homeworkEntity.utility.basic.seventh.RandomNickname;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class LottoPlayer implements Comparable<LottoPlayer> { // Comparable 인터페이스 기능 찾아보기
    private LottoScore score;

  //  private List<LottoNum> lottoNums;

    private String nickName;

    private static final int lottolength = 6;  // 숫자 6개 추출

    private static int lottoSequence; // 몇번째 로또 자리인지

    private static List<Integer> lottoNum; // 실제 추출 번호


    public LottoPlayer() {
        nickName = RandomNickname.makeNickname();
        score = new LottoScore();
    }

    // 6번 숫자 참가자들(2~100) 로또 추첨들어갑니다

    public void gameStart(List<LottoPlayer> players) {

        for (int i = 0; i <lottolength; i++) {
            lottoSequence = i + 1;
            int playerN = i;
            lottoNum = new ArrayList<Integer>();
            int lottoNumber = LottoNum.runLotto();
            lottoNum.add(lottoNumber);    //플레이어 1명의 6개 숫자 번호 lottoNum 배열에 저장됨


            score.ScoreCalculation(lottoNumber, lottoSequence); // 플레이어 1명의 점수 계산

            //점수 계산 전에 동일 숫자 판독해야함
            // 만약 동일 숫자 있으면 checkLottoSameNum()로 계산
            // checkLottoSameNum(List<LottoPlayer> players, int lottoNum, int lottoSequence)


//            LottoNum sameNum = new LottoNum();
//            if(sameNum.checkLottoSameNum(players, lottoNumber, lottoSequence, playerN) == ){
//                score.ScoreCalculation(lottoNumber, lottoSequence); // 플레이어 1명의 점수 계산
//            }



        }
    }



    @Override
    public int compareTo(LottoPlayer player) {
        int srcScore = this.getScore().getTotalScore();
        int dstScore = player.getScore().getTotalScore();

        if (srcScore > dstScore) {
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
