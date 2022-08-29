package kr.eddi.demo.controller.basic.Poker;

import kr.eddi.demo.entity.basic.Poker.BetManager;
import kr.eddi.demo.entity.basic.Poker.Player;
import kr.eddi.demo.entity.basic.Poker.PlayingCards;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Poker")
public class PokerController {
    Player player = new Player();
    Player[] players = new Player[player.getNUM_OF_PLAYER()]; //players선언. 플레이어들은 여기에 담겨있다.

    ArrayList<Integer> shuffledDeck2;

    //Integer[] shuffledDeck; ->초기에 배열로하려다가 너무 어려움이 많아 결국 어레이리스트로 전부 바꾸는중, 이곳저곳 많이 손봐야하는 이슈발생.

    ArrayList<String> RanksOfHands = new ArrayList<>(player.getNUM_OF_PLAYER());//각 플레이어의 족보를 여기에 기록함. -> 족보관리 시스템이 필요함...

    private int curidx=0; //덱 맨위를 의미.

    final int THREE = 3;



        /*players[0].getHands().add(shuffledDeck[0]);
        players[0].getHands().add(shuffledDeck[1]);
        players[0].getHands().add(shuffledDeck[2]);*/

       /* players[1].getHands().add(shuffledDeck[3]);
        players[1].getHands().add(shuffledDeck[4]);
        players[1].getHands().add(shuffledDeck[5]); *///이게 뭐냐...


    //다시 구현해야함.
    public void highCardOpen(){
        int temp;
        ArrayList<Integer> player1Hands = this.players[0].getHands(); //첫번째플레이어의 핸드를 받았다. 이것을 정렬하고싶다.

        if(player1Hands.get(0)%13 > player1Hands.get(1)%13){
            temp = player1Hands.get(1);//백업해두고,
            player1Hands.set(1, player1Hands.get(0));//0번인덱스의 카드가 더 크면, 1번인덱스로 옮긴다.
            player1Hands.set(0, temp);//1번인덱스에 있던 숫자는, 0번으로 옮겨짐
        }
        if(player1Hands.get(1)%13 > player1Hands.get(2)%13){
            temp = player1Hands.get(2);
            player1Hands.set(2, player1Hands.get(1));
            player1Hands.set(1, temp);
        } //ACE(1)이 가장 큰 카드로 취급되지 않는 이슈발생.
        this.players[0].setHands(player1Hands); //정렬한 핸드를 player의 Hands로 대입.


        ArrayList<Integer> player2Hands = this.players[1].getHands(); //두 번째 플레이어의 핸드를 받았다. 역시 정렬하고싶다.

        if(player2Hands.get(0)%13 > player2Hands.get(1)%13){
            temp = player2Hands.get(1);//백업해두고,
            player2Hands.set(1, player2Hands.get(0));//0번인덱스의 카드가 더 크면, 1번인덱스로 옮긴다.
            player2Hands.set(0, temp);//1번인덱스에 있던 숫자는, 0번으로 옮겨짐
        }
        if(player2Hands.get(1)%13 > player2Hands.get(2)%13){
            temp = player2Hands.get(2);
            player2Hands.set(2, player2Hands.get(1));
            player2Hands.set(1, temp);
        } //정렬을 하긴했는데, 너무 지저분함. 유틸리티로 빼면 좋을듯.
        this.players[1].setHands(player2Hands); //정렬한 핸드를 player의 Hands로 대입.
    }

    //deQueue비슷하게 짜보자. 셔플된 덱 맨앞의 카드를 꺼내는 메서드 꺼낸자리는 -1로 바꿈.
    //문제점1 : shuffledDeck이 어레이리스트가 아닌 Integer형 배열이라서 맨 앞에 있는 카드를 꺼내기가 쉽지 않음. 어레이리스트로 바꾸고 싶은데, 여기저기 엮여있어서, 수정이 어려움.
    //수정에 견고한 코드의 필요성 느낌...
    //dealing()을 잘 구현한다면, 처음 3장의 카드를 나누어주는 메소드도 필요가 없어짐. 얘로 다 커버가능.(진행중)
    //문제점2 : 누가 보스인지 판정한 후에 사용가능함. 누가 먼저 카드를 받느냐도 보스를 결정해야 할 수 있는 일.
    //몇 번째 플레이어에게 나누어주는지 구분하기 위해 playeridx 사용
    public void dealing(int playeridx){

        players[playeridx].getHands().add(shuffledDeck2.get(0)); //덱 맨위에 카드를 플레이어에게 주는 행위.
        shuffledDeck2.remove(0); //덱 맨위에 카드는 나눠줬으니 제거.

    }


    //보스를 알려면 현재시점의 각 플레이어 정보(Hands)가 필요하다.
    //보스를 판정하려면 그 시점까지 받은 오픈카드로 족보를 판정해야 한다.(족보판정 메소드가 재사용되어야함)
    public void whoIsTheBoss(Player[] players){
        //미구현
    }


    /*
    public void openYourHands(){
        //미구현
    }*/

   /* public void betting(){
        //미구현
    }*/

    public void sweepTheStake(){
        //미구현
    }


    @GetMapping("/play")
    public String PlayPoker(){
        BetManager betManager = new BetManager();

        PlayingCards deck = new PlayingCards();

        deck.deckShuffle(); //덱 섞음.

        shuffledDeck2 = deck.getPlayingCards2(); //섞은 덱 받아옴.

        betManager.betting(players, 0, 1000000); //플레이어1 100만원 기본배팅
        betManager.betting(players, 1, 1000000); //플레이어2 100만원 기본배팅

        dealing(0);
        dealing(1);
        dealing(0);
        dealing(1);
        dealing(0);
        dealing(1); // 각 플레이어에게 첫 핸드 3장을 나누어주는 행위

        highCardOpen(); //첫 핸드3장을 정렬합니다. 가장 높은카드가 정렬의 과정을 거쳐 가장 뒤에 있음. 이걸 오픈한 카드라고 생각하자.

        dealing(0); //4구 째의 카드를 받습니다. -- 보스판정시스템이 필요해짐.(누구에게 먼저 줄지 결정하고 인자로 playeridx 전달.)
        dealing(1);

        betManager.betting(players, 0, 2000000);
        betManager.betting(players, 1, 2000000); //첫 번째 배팅

        dealing(0);
        dealing(1); //5구째의 카드를 받습니다.

        betManager.betting(players, 0, 4000000);
        betManager.betting(players, 1, 4000000); //두 번쨰 배팅

        dealing(0);
        dealing(1); //6구째의 카드를 받습니다.

        betManager.betting(players, 0, 8000000);
        betManager.betting(players, 1, 8000000); //세 번째 배팅

        dealing(0);
        dealing(1); //7구(히든)를 받습니다.

        betManager.betting(players, 0, 16000000);
        betManager.betting(players, 1, 16000000); //세 번째 배팅

        //openHands(); //서로의 족보를 출력합니다.

        sweepTheStake(); //족보가 높은 쪽이 판돈을 쓸어갑니다.(승자판정을 해야함)



        return "";

    }

}
