package choijaemin.homework.entity.nineth;

import choijaemin.homework.entity.eighth.Player;

public class PockerGameManager {
    private PlayerManager playerManager;
    private RoundManager roundManager;

    private final int DEFAULT_BETTING_MONEY = 1000000;

    public PockerGameManager(int playerNum){
        playerManager = new PlayerManager(playerNum);
        roundManager = new RoundManager();
    }


    public void gameStart(){

        roundManager.firstCardDivide(playerManager);
        roundManager.selectOpenCard(playerManager);
    }

    public void checkWinner(){

    }


}
