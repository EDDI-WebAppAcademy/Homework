package lbk.homework.day0727.secondDiceGame.entity;

import lombok.Getter;

@Getter
public class Player {
    private Score score;

    public Player() {
        score = new Score();
    }
}
