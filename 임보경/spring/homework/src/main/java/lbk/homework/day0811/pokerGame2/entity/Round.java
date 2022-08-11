package lbk.homework.day0811.pokerGame2.entity;


import lombok.Getter;

@Getter
public class Round {

    private int currentRound;

    public Round() {
        currentRound = 0;
    }

    public void playPockerGame() {
        System.out.println("현재 라운드: " + currentRound);
    }
}
