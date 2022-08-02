package dice.test.sixthExample.diceClean.utillity;

import dice.test.sixthExample.diceClean.entity.Player;

import java.util.List;

public interface DiceOption {
    public void checkSpecialDice(List<Player> players, int diceNum, int playerIdx);
}

