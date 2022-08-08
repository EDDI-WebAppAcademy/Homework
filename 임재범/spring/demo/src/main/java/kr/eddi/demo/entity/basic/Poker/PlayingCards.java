package kr.eddi.demo.entity.basic.Poker;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
public class PlayingCards {

    //0~12(스페이드에이스~스페이드킹), 13~25(다이아에이스~다이아킹), 26~38(하트에이스~하트킹), 39~51(클럽에이스~클럽킹)
    ArrayList<Integer> playingCards2 = new ArrayList<>();

    //0~12(스페이드에이스~스페이드킹), 13~25(다이아에이스~다이아킹), 26~38(하트에이스~하트킹), 39~51(클럽에이스~클럽킹)
  /* Integer[] playingCards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
            26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};*/


    //커밋해볼때 반환형 잠시 String으로 바꾼것.
    public String deckShuffle(){

        for(int i=0; i<52; i++){
            playingCards2.add(i);
        } //0~51 삽입.

        List<Integer> list = playingCards2;

        Collections.shuffle(list);

        playingCards2 = (ArrayList<Integer>) list;


        return "";
    }


}
