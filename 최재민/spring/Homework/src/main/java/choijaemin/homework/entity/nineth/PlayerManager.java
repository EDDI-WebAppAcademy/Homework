package choijaemin.homework.entity.nineth;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerManager {
    List<Player> player;
    private int playerNum;
    public PlayerManager(int playerNum){
        this.playerNum = playerNum;
        createPlayer(playerNum);
    }

    public void createPlayer(int playerNum){
        player = new ArrayList<>();
        createPlayerObj(player , playerNum);
    }

    public void createPlayerObj(List<Player> players ,int playerNum){
        for (int i = 0; i < playerNum; i++) {
            players.add(new Player());
        }
    }
}
