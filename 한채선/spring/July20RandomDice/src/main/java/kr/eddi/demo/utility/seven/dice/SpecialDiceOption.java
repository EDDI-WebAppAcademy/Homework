package kr.eddi.demo.utility.seven.dice;

import kr.eddi.demo.entity.basic.six.dicegame.Player;

import java.util.ArrayList;

public interface SpecialDiceOption {

    public default void checkSpecialDice(ArrayList<Player> players, int diceNum, int playerIdx) {}

}
