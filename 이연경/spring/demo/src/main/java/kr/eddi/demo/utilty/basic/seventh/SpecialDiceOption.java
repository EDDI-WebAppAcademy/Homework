package kr.eddi.demo.utilty.basic.seventh;




import kr.eddi.demo.entity.basic.seventh.Player;

import java.util.List;

// interface는 매서드 프로토타입만 작성한다.
// 프로토타입: 리턴타입, 매서드 이름, 파라메터
public interface SpecialDiceOption {
    public void checkSpecialDice(List<Player> players, int diceNum, int playerIdx);
}

