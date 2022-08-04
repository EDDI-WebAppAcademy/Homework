package kr.eddi.demo.controller.basic.Poker;

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
    Player[] players = new Player[player.getNUM_OF_PLAYER()]; //players선언.
    Integer[] shuffledDeck; //섞여진 덱.
    ArrayList<String> RanksOfHands = new ArrayList<>(player.getNUM_OF_PLAYER());//각 플레이어의 족보를 여기에 기록함. -> 족보관리 시스템이 필요함...


    final int THREE = 3;

    //세장씩 나누어가짐.
    public void firstThreeCardsDeal(){
        for(int i=0; i<players.length; i++){
            for(int j=0; j<3*players.length; j++){
                players[i].getHands().add(shuffledDeck[j]);
                        if(j%3==2){
                            break;
                        }
            }
        }
        /*players[0].getHands().add(shuffledDeck[0]);
        players[0].getHands().add(shuffledDeck[1]);
        players[0].getHands().add(shuffledDeck[2]);*/

       /* players[1].getHands().add(shuffledDeck[3]);
        players[1].getHands().add(shuffledDeck[4]);
        players[1].getHands().add(shuffledDeck[5]); *///이게 뭐냐...
    }

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
        } //정렬을 하긴했는데, 너무 지저분함. 유틸리티로 빼면 좋을듯.

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
    }

    //deQueue비슷하게 짜보자. 셔플된 덱 맨앞의 카드를 꺼내는 메서드 꺼낸자리는 -1로 바꿈.
    //문제점 : shuffledDeck이 어레이리스트가 아닌 Integer형 배열이라서 맨 앞에 있는 카드를 꺼내기가 쉽지 않음. 어레이리스트로 바꾸고 싶은데, 여기저기 엮여있어서, 수정이 어려움.
    //수정에 견고한 코드의 필요성 느낌...
    public int dealing(){
        int len;

        return 50;
    }

    public void openYourHands(){
        //미구현
    }

    public void betting(){
        //미구현
    }

    public void sweepTheStake(){
        //미구현
    }


    @GetMapping("/play")
    public String PlayPoker(){

        PlayingCards deck = new PlayingCards();

        deck.deckShuffle(); //덱 섞음.
        shuffledDeck = deck.getPlayingCards(); //섞은 덱 받아옴.

        firstThreeCardsDeal();//첫 세장의 카드를 양 플레이어에게 나누어줍니다.

        highCardOpen(); //첫 핸드3장을 정렬합니다. 가장 높은카드가 가장 뒤에 있음. 이걸 오픈한 카드라고 생각하자...

        dealing(); //1장을 카드를 추가로 받습니다.

        betting(); //양플레이어는 일정금액을 배팅합니다. -> 보통 4번의 배팅이 이루어짐

        dealing(); //2번째 카드를 받습니다.

        betting(); //또다시 배팅

        dealing(); //3번째 카드를 받습니다.

        betting(); //배팅

        dealing(); //4번째카드(히든)을 받습니다.

        betting(); //마지막 배팅.

        openYourHands(); //서로의 족보를 출력합니다.

        sweepTheStake(); //족보가 높은 쪽이 판돈을 쓸어갑니다.



        return "";

    }

}
