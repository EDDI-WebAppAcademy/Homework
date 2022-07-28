package kr.eddi.demo.entity.basic.fifth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class DiceGame {
    private final int MAX = 6;
    private final int MIN = 1;
    private int defaultPlayerCnt = 3;
    private int[] PlayerScore;
    private String[] showPlayerScore;

    public DiceGame() {
      this.PlayerScore = new int[defaultPlayerCnt];
      this.showPlayerScore = new String[defaultPlayerCnt];
    }

    public DiceGame(int PlayerCnt){
        this.PlayerScore = new int[PlayerCnt];
        this.showPlayerScore = new String[PlayerCnt];
    }



    public String RollDice(){
        for (int CurrentPlayer = 0; CurrentPlayer < PlayerScore.length ; CurrentPlayer++) {
            System.out.println(CurrentPlayer+ "번째 플레이어의 "+"첫 번째 주사위를 던집니다.");
            int RollFirstDiceNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
            if ((RollFirstDiceNum%2)==0){
                System.out.println("첫번째 주사위의 결과가" + RollFirstDiceNum+"임으로 한번더 던집니다.");
                // 두번째 다이스 실행
                if (RollSecondDice(RollFirstDiceNum,CurrentPlayer) == 4 ) break;
            } else {
                System.out.println("첫번째 주사위 결과가" +RollFirstDiceNum +"임으로 다음플레이어에게 기회가 넘어갑니다.");
            }
            this.PlayerScore[CurrentPlayer] += RollFirstDiceNum;
        }

        for (int j = 0; j < showPlayerScore.length; j++) {
            showPlayerScore[j] = String.format(j+1+"번째 플레이어의 점수는 " + PlayerScore[j] +"입니다.");
        }

        return Arrays.toString(showPlayerScore);
    }

    public String RollDice(int GameLoopGame){
        System.out.println("단판이 아닌 " + GameLoopGame + "번 턴을 돌립니다");
        for (int i = 0; i < GameLoopGame; i++) {
            System.out.println(i+1 + "번째 턴 시작!");
            for (int CurrentPlayer = 0; CurrentPlayer < PlayerScore.length ; CurrentPlayer++) {
                System.out.println(CurrentPlayer +1+ "번째 플레이어의 "+"첫 번째 주사위를 던집니다.");
                int RollFirstDiceNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
                if ((RollFirstDiceNum%2)==0){
                    System.out.println("첫번째 주사위의 결과가" + RollFirstDiceNum+"임으로 한번더 던집니다.");
                    // 두번째 다이스 실행
                    if (RollSecondDice(RollFirstDiceNum,CurrentPlayer) == 4 ) break;
                } else {
                    System.out.println("첫번째 주사위 결과가" +RollFirstDiceNum +"임으로 다음플레이어에게 기회가 넘어갑니다.");
                }
                this.PlayerScore[CurrentPlayer] += RollFirstDiceNum;
            }
        }
        for (int j = 0; j < showPlayerScore.length; j++) {
            showPlayerScore[j] = String.format(j+1+"번째 플레이어의 점수는 " + PlayerScore[j] +"입니다.");
        }

        return Arrays.toString(showPlayerScore);
    }


    public int RollSecondDice(int FirstDiceNum,int CurrentPlayer){
        int FirstScore = FirstDiceNum;
        int RollSecondDiceNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
        switch (RollSecondDiceNum){
            case 1://숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다
                System.out.println("모든 플레이어의 점수가 2점 차감 됩니다.");
                for (int i = 0; i < PlayerScore.length; i++) {
                    PlayerScore[i] -= -2;

                    if (PlayerScore[i] <= 0){
                        PlayerScore[i] = 0;
                    }

                }
                PlayerScore[CurrentPlayer] +=1;
                return 1;


            case 3://숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.
                System.out.println("나이스! 모든 플레이어에게 3점씩 받습니다!");
                for (int i = 0; i < PlayerScore.length; i++) {
                    if (i != CurrentPlayer){
                        PlayerScore[i] -= 3;

                        if (PlayerScore[i] <= 0){
                            PlayerScore[i] = 0;
                        }

                    }
                }
                PlayerScore[CurrentPlayer] += ((PlayerScore.length*3)-3);
                return 3;


            case 4://숫자 4가 나오는 경우 즉시 게임 오버된다.
                System.out.println("죽음의 4 두두등장 게임이 종료됩니다.");
                return 4;


            case 5://숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.
                System.out.println("아이고! 당신은 기부천사! 2점씩 나누어주세요~");
                for (int i = 0; i < PlayerScore.length; i++) {
                    if (i != CurrentPlayer){
                        PlayerScore[i] += 2;
                    }
                }
                PlayerScore[CurrentPlayer] -= ((PlayerScore.length*2)-2);
                if (PlayerScore[CurrentPlayer] <= 0){
                    PlayerScore[CurrentPlayer] = 0;
                }

                return 5;
            default:// 특수 기능 x
                System.out.println("까비~ 숫자가 "+ RollSecondDiceNum+" 임으로 특수 기능이 발생하지 않습니다 ");
                PlayerScore[CurrentPlayer] += RollSecondDiceNum;

                return 6;
        }
    }


}
