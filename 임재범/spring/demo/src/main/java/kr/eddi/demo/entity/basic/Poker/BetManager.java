package kr.eddi.demo.entity.basic.Poker;

import lombok.Getter;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;

//판돈 관리. Player의 money에 접근해서 어떤배팅을 할것인지 관리. 0라운드:100만, 1라운드
@Getter
@Setter
public class BetManager {


    private int stake = 0;

    //몇번째 플레이어(playeridx)가 얼마나 배팅할지(betAmount)

    public void betting(Player[] players, int playeridx, int betAmount){
        players[playeridx].setMoney(players[playeridx].getMoney()-betAmount); //지저분함.
        stake += betAmount; //배팅한 금액만큼 그 플레이어의 자금에서 돈이 빠져나가고, 그 돈은 stake(판돈)에 쌓임.
    } //너무 기능에 치우친듯
}
