package kr.eddi.demo.utility.ten.dicegamebymyself;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class DiceSkills{

    private int totalDiceScore;


    public int allMinus(int score) {
        return 0;
    }

    public int takeThreePoints() {
        return 0;
    }

    public int giveTwoPoints(){
        return 0;
    }

    public String gameIsOver() {
        return "게임 종료";
    }

}
