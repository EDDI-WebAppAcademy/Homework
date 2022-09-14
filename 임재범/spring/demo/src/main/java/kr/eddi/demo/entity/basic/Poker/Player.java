package kr.eddi.demo.entity.basic.Poker;

import kr.eddi.demo.entity.basic.practice2.Array;
import kr.eddi.demo.utility.basic.Poker.RandomNickName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


//2포라고 가정.
@Setter
@Getter
public class Player {

    final int SEVEN_POKER = 7;
    final int FIVE_CARD = 5;
    final int NUM_OF_PLAYER = 2;
    private String name; //이름
    private int money; //자금

    ArrayList<Integer> Hands;
    //int[] Hands;

    public Player(){
        RandomNickName randomNick = new RandomNickName();
        this.name = randomNick.RandomNick();//닉네임생김.
        this.money = 100000000; //1억원
        Hands = new ArrayList<>(SEVEN_POKER); //세븐포커니까 7칸 할당한다는 뜻.
    }



}
