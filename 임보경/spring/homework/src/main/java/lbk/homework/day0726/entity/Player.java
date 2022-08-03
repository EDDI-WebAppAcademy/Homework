package cls.i.lecture.day0726.entity;

import cls.i.lecture.day0726.utility.RandomNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Player {

    private int playerNum;
    // 플레이어 수 변동가능.
    private int activePlayer;
    private int min_number = 2;
    private int max_number = 4;
    private RandomNumber ranNumb;



    public Player() {
        ranNumb = new RandomNumber();
        this.playerNum = ranNumb.makeRandom(max_number, min_number);
    }

    //플레이어 관리
    //현재 플레이어 관리가 안됨

}
