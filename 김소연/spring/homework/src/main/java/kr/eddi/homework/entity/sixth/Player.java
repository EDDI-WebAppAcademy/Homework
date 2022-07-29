package kr.eddi.homework.entity.sixth;

import java.util.ArrayList;

public class Player {

    public static ArrayList<Integer> players(int playerNum, int firstScore) {
        ArrayList<Integer> playerArr = new ArrayList<>();
        for (int i = 0; i < playerNum; i++) {
            playerArr.add(firstScore);
        }
        return playerArr;
    }
}
