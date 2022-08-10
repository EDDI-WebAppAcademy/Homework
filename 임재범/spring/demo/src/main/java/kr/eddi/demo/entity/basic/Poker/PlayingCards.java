package kr.eddi.demo.entity.basic.Poker;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
public class PlayingCards {


    ArrayList<Integer> playingCards2 = new ArrayList<>();




    //커밋해볼때 반환형 잠시 String으로 바꾼것.
    public void deckShuffle(){

        for(int i=0; i<52; i++){
            playingCards2.add(i);
        } //0~51 삽입. //0~12(스페이드에이스~스페이드킹), 13~25(다이아에이스~다이아킹), 26~38(하트에이스~하트킹), 39~51(클럽에이스~클럽킹)
        //%13 후 +1하면 카드숫자. 그 수가 1인경우,,, ACE이기 때문에 예외처리가 필요함.

        List<Integer> list = playingCards2;

        Collections.shuffle(list);

        playingCards2 = (ArrayList<Integer>) list;


    }


}
