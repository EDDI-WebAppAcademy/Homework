package kr.eddi.demo.entity.augusttwelve;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private final String DEFAULT_NAME = "anonymous";

    private List<Player> players;
    private Player player;
    private FoodItems foodItems = new FoodItems();

    public void setPlayers(int playerNum) {
        players = new ArrayList<>();
        for (int i = 0; i < playerNum; i++) {
            player = new Player(DEFAULT_NAME + i);
            players.add(player);
        }

    }

    public void eatFood(String food, List<Player> players, int playerIdx) {
        foodItems.applyFoodSkills(food, players, playerIdx);
    }

    public void eatFoodSeveralTimes(String food, int foodCount,List<Player> players, int playerIdx){
        for (int i = 0; i < foodCount; i++) {
            eatFood(food, players, playerIdx);
        }
    }
}
