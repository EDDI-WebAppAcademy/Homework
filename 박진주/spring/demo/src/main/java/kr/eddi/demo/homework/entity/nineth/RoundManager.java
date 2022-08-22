package kr.eddi.demo.homework.entity.nineth;

public class RoundManager {

    public static int currentRound;


    public RoundManager(){
        currentRound = 0;
    }

    public void roundStart(){   // 해당 라운드 - 몬스터 배정 메소드 포함
        System.out.println("현재 라운드: " + currentRound);


        // 몬스터 클래스의 배정 메소드 호출 (랜덤으로 배정되게 )


        //playerManager.playPockerGame(currentRound++);
        roungFight(currentRound++);                                 // ++이면 처음엔 0부터 시작하겠지? ㅎ



    }

    public void roungFight(int currentRound){
        // PlayerManager.attackPriority(); -> 아래 실제 fight 메소드 인자에 들어가므로 필요헚음
        // PlayerManager.fight(PlayerManager.attackPriority()); // 공격우선권 결과 받아서 우선있는 쪽이 공격하기
    }

}
