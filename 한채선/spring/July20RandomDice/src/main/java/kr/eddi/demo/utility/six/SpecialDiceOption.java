package kr.eddi.demo.utility.six;

import kr.eddi.demo.entity.six.dicegame.Player;

public interface SpecialDiceOption {

    public default void checkSpecialDice(Player player[], int diceNum, int playerIdx) {}
}
