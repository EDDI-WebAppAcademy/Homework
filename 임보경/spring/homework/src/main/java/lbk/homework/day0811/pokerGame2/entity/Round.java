package lbk.homework.day0811.pokerGame2.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Round {

    private int currentRound;

    public Round() {
        currentRound = 1;
    }

    public void playPockerGame() {
        System.out.println("현재 라운드: " + currentRound);
    }
    public void nextTurn() {currentRound++;}
}
