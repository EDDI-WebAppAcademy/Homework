package kr.eddi.demo.utility.basic.Poker;


import kr.eddi.demo.entity.basic.Poker.Player;

import java.util.ArrayList;


//족보를 판정하자. - 족보를 판정하려면 플레이어 정보가 필요하다.(Player가 가진 Hands가 필요함)
public class HandRankings {

    Player player = new Player();



   public boolean isFlush(Player player){
       //같은 문양이 5개 이상이라는 걸 어떻게 확인할까? cnt를 이용하면 될듯? 같은문양이 7개일수도 있고, 6개일수도 있고, 5개일수도 있어.
       //SpadeCnt, DiamondCnt, HeartCnt, ClubCnt를 각각 0으로 초기화하고, 쭉 한바퀴 돌면서 발견될때마다 ++해주는 식.

       int SpadeCnt = 0;
       int DiamondCnt = 0;
       int HeartCnt = 0;
       int ClubCnt = 0; //어차피 얘네들은 여기서만 씀.

       //player는 Hands를 가지고 있다. Hands(손패)의 각요소를 get해서 문양별로 cnt를 증가시켜준다.
       for(int i=0; i<player.getSEVEN_POKER(); i++){
           //0~12(스페이드에이스~스페이드킹), 13~25(다이아에이스~다이아킹), 26~38(하트에이스~하트킹), 39~51(클럽에이스~클럽킹)
           if(player.getHands().get(i)>=0 && player.getHands().get(i)<=12){
               SpadeCnt++;
           }
           else if(player.getHands().get(i)>=13 && player.getHands().get(i)<=25){
               DiamondCnt++;
           }
           else if(player.getHands().get(i)>=26 && player.getHands().get(i)<=38){
               HeartCnt++;
           }
           else if(player.getHands().get(i)>=39 && player.getHands().get(i)<=51){
               ClubCnt++;
           }
       }
       //문양별cnt가 5이상이면 플러시이다.(A플러시인지, 8플러시인지... 구분되어야함. - 점수시스템 고안중.)
       if(SpadeCnt>=5){
        return true;
       }
       else if(DiamondCnt>=5){
           return true;
       }
       else if(HeartCnt>=5){
           return true;
       }
       else if(ClubCnt>=5){
           return true;
       }
       else{
           return false;
       }

   }


   //5개 이상의 숫자가 연속되면 스트레이트이다. 이것은, 정렬을통해 해결할수 있을듯?
   public boolean isStraight(Player player){


       return true;
   }

}
