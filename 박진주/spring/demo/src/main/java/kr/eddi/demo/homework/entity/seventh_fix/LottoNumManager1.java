package kr.eddi.demo.homework.entity.seventh_fix;


import kr.eddi.demo.homework.utility.seventh_fix.LottoNum1;
import kr.eddi.demo.homework.utility.seventh_fix.PreventLottoSameNumOption;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LottoNumManager1 implements PreventLottoSameNumOption { //implements PreventLottoSameNumOption , Comparable<LottoPlayer> {

    public List<LottoNum1> lottoNum1;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    public LottoNumManager1(int playerNum) {
      //  log.info("로또넘버매니저 생성됩니다");
        // lottonum 을 100개 생성
        lottoNum1 = new ArrayList<>(playerNum);

        for (int i = 0; i < playerNum; i++) {
            lottoNum1.add(new LottoNum1());
        }
    }


    // 6번 숫자 참가자들(2~100) 로또 추첨들어갑니다
    public void allocLottoNum() {

        int lottoNum;
        int people = lottoNum1.size();

        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {    //for (int j = 0; j < people; j++) {                // i = 0,,,6
           // lottoSequence = i + 1;

            for (int j = 0; j < people; j++)    //j= 0,,,99
                do {
                    lottoNum = lottoNum1.get(j).runLotto(i);       // list.get(i)는 뒤에 메소드() 실행결과가 저장도 되는 방식
                    //즉, lottoNum1[i] 배열에 존재하는 number배열에 runLotto() 메소드의 실행 결과가 저장됨
                    // 로또 번호 1개 받음 // number에 저장도 됨

                } while (checkLottoSameNum(i, j, lottoNum1));
            }

        }



    @Override                                // i = 0 ~ 6      , j = 0 ~ 99
    public boolean checkLottoSameNum(int lottoSeqence1, int playerIdx, List<LottoNum1> lottoNum1 ) {
        if (playerIdx == 0) { return false; }
        int compareTarget = lottoNum1.get(playerIdx).getNumbers()[lottoSeqence1];

        for (int i = 0; i < playerIdx; i++) {    // 여러 참가자들의 로또 번호 순서 다 비교하므로 반복문 실행
            int compareNum = lottoNum1.get(i).getNumbers()[lottoSeqence1];
            if( compareTarget == compareNum) {
                return true;
            }
        }

        return false;
    }



}








//    public void gameStart(List<LottoPlayer> players) {
//
//        for (int i = 0; i < lottolength; i++) {
//            lottoSequence = i + 1;
//
//            lottoNum = new ArrayList<>();
//            //beforeLottoNum = new ArrayList<Integer>();
//
//
//            int lottoNumber = LottoNum.runLotto();// 로또 번호 1개 받음
//            lottoNum.add(lottoNumber);
//
//            //********** sameNum에 플레이어 각각의 넘버가 저장되어야 하는데.. 그게 빠짐.. sameNum은 그냥 계속 저장될뿐..
//
//            LottoNum sameNum = new LottoNum(lottoNumber); // sameNum 객체 생성 (나온 로또 번호 )
//            checkBeforeLottoNum = lottoNumber;             // 받은 로또 번호 비포 변수에 저장
//
//            if (!sameNum.checkLottoSameNum(players, sameNum, lottoSequence)) {  // 만약 동일 자리에 중복 숫자 돌려봄. 동일숫자 없으면 = false면
//                sameNum.saveLottoNum(lottoNumber); //플레이어 1명의 6개 숫자 번호 lottoNum 배열에 저장됨
//                sameNum.checkAfterLottoNum.add(lottoNumber);
//                score.ScoreCalculation(lottoNumber, lottoSequence); // 플레이어 1명의 점수 계산   // 동일 숫자 있으면 저장하지 않고 다시 돌리기
//
//                //점수 계산 전에 동일 숫자 판독해야함
//                // 만약 동일 숫자 있으면 checkLottoSameNum()로 계산
//                // checkLottoSameNum(List<LottoPlayer> players, int lottoNum, int lottoSequence)
//            } else {
//                i = i - 1;
//            }
//        }
//    }
//
//
//    @Override
//    public boolean checkLottoSameNum(List<LottoPlayer> players, LottoNum lottoNum, int lottoSequence) {
//
//        boolean checkResult = false;
//
//        // checkLottoSameNum는 플레이어 객체 정보가 필요함
//        //  List<LottoPlayer> players, int lottoNum, int lottoSequence
//
//        //로또 순서 받았고, 번호도 받음, 플레이어 정보도 받름
//        if (!ObjectUtils.isEmpty(players)){  // 플레이어 정보가 존재할때 아래를 실행해라
//
//            for (int i = 1; i < players.size() - 1 ; i++) {    // 여러 참가자들의 로또 번호 순서 다 비교하므로 반복문 실행
//
//                if(!ObjectUtils.isEmpty(players.get(i + 1))){  // player 0부터 비교할건데 player1이 존재하는 경우 실행
//
//                    if (Objects.equals(players.get(i).getNickName(), players.get(i + 1).getNickName())) {
//                        continue;
//                    }
//                    checkResult = Objects.equals(lottoNum.beforeLottoNum, lottoNum.haveLottoNum);
//                }
//
//            }
//        }
//
//        return checkResult;
//    }//players.get(i).getCheckBeforeLottoNum(), players.get(i + 1).getCheckAfterLottoNum().get(lottoSequence-1)
//
//
//    @Override
//    public int compareTo (LottoPlayer player){
//        int srcScore = this.getScore().getTotalScore();
//        int dstScore = player.getScore().getTotalScore();
//
//        if (srcScore > dstScore) {
//            return 1;
//        } else if (srcScore < dstScore) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
//
//}
