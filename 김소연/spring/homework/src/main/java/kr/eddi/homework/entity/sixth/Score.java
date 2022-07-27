package kr.eddi.homework.entity.sixth;

import java.util.ArrayList;
import java.util.Collections;

public class Score {

    //점수관리x

    public int getHighScore() {
        ArrayList<Integer> highScore = new ArrayList<>();
        return Collections.max(highScore);
    }
}
