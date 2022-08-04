package kr.eddi.demo.entity.basic.Poker;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
public class PlayingCards {

    //0~12(스페이드에이스~스페이드킹), 13~25(다이아에이스~다이아킹), 26~38(하트에이스~하트킹), 39~51(클럽에이스~클럽킹)
   Integer[] playingCards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
            26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public void deckShuffle(){
        List<Integer> list = Arrays.asList(playingCards);
        Collections.shuffle(list);
        list.toArray(playingCards); //섞인것 웹상에 띄워서 확인함. 덱셔플메소드 호출하면, playingCards에 0~51숫자 섞여서 저장됨.
        //return Arrays.toString(playingCards);

    }

}
