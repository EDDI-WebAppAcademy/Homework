package kr.eddi.demo.entity.homework.sixth;

import kr.eddi.demo.entity.basic.third.Score;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private int player;
    private int[] players;
    private final int MIN = 3;
    private final int MAX = 10;

    //플레이어 수를 3~10명 사이 랜덤 수로 진행.
    public Player() {
        player = CustomRandom.makeIntCustomRandom(MIN, MAX);
        players = new int[player];
    }


}
