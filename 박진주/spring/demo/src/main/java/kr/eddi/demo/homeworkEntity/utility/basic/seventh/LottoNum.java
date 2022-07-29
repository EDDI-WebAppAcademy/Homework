package kr.eddi.demo.homeworkEntity.utility.basic.seventh;

import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import kr.eddi.demo.homeworkEntity.seventh.LottoPlayer;

import java.util.List;


public class LottoNum { //implements PreventLottoSameNumOption
    private static final int MIN = 0;  // 로또 번호 최소값
    private static final int MAX = 99;   // 로또 번호 최대값


    public static int runLotto() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }


    // checkLottoSameNum는 플레이어 객체 정보가 필요함
    //  List<LottoPlayer> players, int lottoNum, int lottoSequence
//    @Override
//    public void checkLottoSameNum(List<LottoPlayer> players, int lottoNum, int lottoSequence) {
//
//        for (int i = 0; i < players.size(); i++) {   // 플레이어 돌린 사람 만큼 로또 번호 가 다른 사람 번호랑 중복인지 비교
//                                                       //닉네임 동일하면 건너뛰기
//            if(players.get(i).getLottoNums(i) ==  ) {
//
//            }
//        }
//    }
}