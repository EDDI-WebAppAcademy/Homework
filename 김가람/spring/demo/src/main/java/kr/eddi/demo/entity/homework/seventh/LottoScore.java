package kr.eddi.demo.entity.homework.seventh;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class LottoScore { // 점수를 받아서 플레이어에 전달
    private int totalLottoScore;


        // totalLottoScore = [ (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6 ];
        // -> 이걸 하려면 점수가 로또 넘버를 관리해야하나? // 아니면 로또 넘버에서 계산해야하나?

}
