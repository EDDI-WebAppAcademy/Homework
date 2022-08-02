package kr.eddi.demo.entity.homework.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.utility.basic.seventh.Dice;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
public class Participant {

    private final int pax = 100;
    private String nickname;
    private LottoScore lottoScore;

    private List<LottoNumber> lottoNumber;

    public Participant() {
        this.nickname = "DEFAULT";
        lottoScore = new LottoScore();
    }

//    public void gameStart(List<Player> players, int playerIdx) {
//        int diceNum = Dice.rollDice();
//        score.addScore(diceNum);
//
//        if (diceNum % 2 == 0) {
//            diceNum = Dice.rollDice();
//            Dice specialDice = new Dice();
//            score.addScore(diceNum);
//
//            specialDice.checkSpecialDice(players, diceNum, playerIdx);
//            // 왜 인스턴스화 시키는지 이해안감. Dice.rollDice()처럼 사용이 안되나?
//        }

    // 시스템 작동할 메서드 필요
    public void runSystem(List<Participant> participants, int ppIdx) {
        //로또 번호를 돌려
        int lottoNum = CustomRandom.makeIntCustomRandom(0, 99);
        // 번호를 ArrayList나 HashMap에 담아.

        // 번호를 중복 체크하여 부여해

        // 점수 계산해서 totalscore에 넣어
    }

}
