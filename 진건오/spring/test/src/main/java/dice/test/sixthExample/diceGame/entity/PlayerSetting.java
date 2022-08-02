package dice.test.sixthExample.diceGame.entity;

import lombok.Getter;

@Getter
public class PlayerSetting {

    public static int[] playerScoreSetting(int numberOfPlayers, int startPlayersScore) {
        int[] playerScore = new int[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            playerScore[i] = startPlayersScore;
        }
        return playerScore;
    }

}
