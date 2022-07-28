package kr.eddi.demo.homeworkEntity.sixth;


//게임 점수 합산 - 우승자 도출
public class GameResult {

    // 플레이어 토탈점수 가져와야함
    // 점수 합산

    public int winner;


     Score gscore = new Score();
     Dice gdice = new Dice();

    public String findDiceGameWinner(){
        gdice.rollDice();
        int maxScore = gscore.totalScore[0];

        for (int i = 0; i < gscore.totalScore.length; i++) {
            if(gscore.totalScore[i]> maxScore){
                System.out.println( i + "번째 사용자가 점수가 더 높습니다.");
                maxScore = gscore.totalScore[i];
                winner = gscore.playerNum[i];
            }
        }
        return "우승자는 " + maxScore +"점으로 "+ winner +"번째 참가자입니다.";
    }
}
