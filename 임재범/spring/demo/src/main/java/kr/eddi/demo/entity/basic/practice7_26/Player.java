package kr.eddi.demo.entity.basic.practice7_26;

import java.util.ArrayList;
import kr.eddi.demo.utility.basic.third.CustomRandom;

import lombok.*;

@Getter
@Setter
public class Player {

    final int NUMOFTHROWS = 2; //플레이어별 던진 횟수.
    private int playerNum; //플레이어의 수

    CustomRandom rand = new CustomRandom();



    public Player(int num){
        this.playerNum = num; //몇명 있는지 받아놓기만 하자. 이걸 가지고 스코어보드 작성
    }


}


