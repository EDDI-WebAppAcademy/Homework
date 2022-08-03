package choijaemin.homework.entity.nineth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private Dealer dealer;
    private Score score;
    private int defaultMoney = 100000000;
    private final int ADDITION_BAT_CNT = 4;
    private HashMap<String , ArrayList<Integer>> totalCard = new HashMap<>();



    public void gameStart(){
        dealer = new Dealer();
        dealer.firstCardDivide(); // 카드 3개 받고 확인
        // 다음 할일은 ? -->  카드 오픈  --> 배팅 여부 결정  --> 추가카드 발급( 딜러 )
        // 간과하고 있던것 --> 이건 지금처럼 순차적으로 플레이어가 모든 활동을 하는것아니라
        // 턴제게임 턴을 어떤식으로 넘겨주어야 할지 고민필요.
        totalCard = dealer.getFirstCard();

        for (int i = 0; i <ADDITION_BAT_CNT; i++) {
            System.out.println("현재 패는 " + totalCard +"입니다.");
            dealer.selectOpenCard(totalCard);
               if (askAdditionalBetMoney() == true){
                // 추가 카드 발급
            }else {
                // 이번턴은 패배로 처리
                break;
            }
       }

    }


    public boolean askAdditionalBetMoney(){


        return false;
    }
}
