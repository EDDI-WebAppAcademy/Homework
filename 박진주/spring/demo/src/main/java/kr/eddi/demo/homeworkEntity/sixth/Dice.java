package kr.eddi.demo.homeworkEntity.sixth;

import lombok.AllArgsConstructor;

// 주사위 게임

@AllArgsConstructor
public class Dice {
    private int gameNum = 1;   // 몇번째 판인지, 디폴트 1번째 판

    private int join = 0; //게임 참가 여부 참가했으면 1, 아니면 0 ( 디폴트는 0)
    private int dicePlayerNum;// 참가자 번호 1,2,3,4,5

    private int myNumber; //본인 몇번째 인지 본인 점수 구분용

    private int max = 6;
    private int min = 1;

    public Player player;
    public Score score;

    public Dice() {
        player = new Player();
        score = new Score();
    }

    public void rollDice() {


        for (int i = 0; i < player.playerNum.length; i++) {   // 플레이어 순서대로 실행
            dicePlayerNum = i + 1;
            System.out.println(dicePlayerNum+"번째 참가자 1번째 주사위게임");
            myNumber = i;
            player.join[i] = 1;
            int diceResult1 = (int) (Math.random() * (max - min + 1) + min);


            if (diceResult1 % 2 == 0) {   // 첫번째 판 짝수면 rollDiceAgain 메소드 해라
                gameNum = 2;
                score.score1[i] = diceResult1;
                rollDiceAgain(diceResult1);
            } else {
                gameNum = 1;
                score.score1[i] = diceResult1;
                score.totalScore[i] = diceResult1;
                score.scoreplayerNum[i] = dicePlayerNum;
                player.playerNum[i] = dicePlayerNum;
            }
        }

    }
    public void rollDiceAgain(int diceResult1){
        System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임");

        int diceResult2 = (int) (Math.random()* (max - min + 1) + min);

        switch (diceResult2) {
            case 1:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                for (int i = 0; i <player.playerNum.length; i++) {

                    if (player.join[i] == 1) {            //게임 참가한 경우에만
                        if(score.totalScore[i] > 0 && score.totalScore[i] >= 2 ) {  //0점이상, 2점이상 경우
                            score.totalScore[i] -= 2;
                        } else if (score.totalScore[i] == 1 ){ //0점이상, 2점미만 경우 -> 1
                            score.totalScore[i] -= score.totalScore[i];         //i번째 친구는 -자기 점수 만큼
                        }
                    }

                }
                //숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다.

            case 2:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                score.totalScore[myNumber] = diceResult1 + diceResult2;

            case 3:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                for (int i = 0; i <player.playerNum.length; i++) {
                    if(i == myNumber){           // 본인 차례 돌아왔을때는 해당 차례 건너뛰기
                        continue;
                    }
                    if (player.join[i] == 1) {         //게임 참가한 경우에만
                        if(score.totalScore[i] > 0 && score.totalScore[i] >= 3 ) {  //0점이상, 3점이상 경우
                            score.totalScore[i] -= 3;         //i번째 친구는 -3점
                            score.totalScore[myNumber] = + 3;    //나는 +3점
                        } else if (score.totalScore[i] > 0 && score.totalScore[i] < 3 ){ //0점이상, 3점미만 경우
                            score.totalScore[i] -= score.totalScore[i];         //i번째 친구는 -자기 점수 만큼
                            score.totalScore[myNumber] = + score.totalScore[i];    //나는 +친구 점수만큼
                        }
                    }
                }
                //숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.

            case 4:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                score.totalScore[myNumber] = 0;

                //숫자 4가 나오는 경우 즉시 게임 오버된다.

            case 5:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                for (int i = 0; i <player.playerNum.length; i++) {
                    if(i == myNumber){           // 본인 차례 돌아왔을때는 해당 차례 건너뛰기
                        continue;
                    }
                    if(score.totalScore[myNumber] >= 2){  //내 점수 2점 이상
                        score.totalScore[i] += 2;         //i번째 친구는 +2점
                        score.totalScore[myNumber] -= 2;    //나는 -2점

                    } else if (score.totalScore[myNumber] == 1) {
                        score.totalScore[i] += score.totalScore[myNumber];         //i번째 친구는 +1점
                        score.totalScore[myNumber] -= score.totalScore[myNumber];    //나는 -1점
                    }


                }

            case 6:
                System.out.println(dicePlayerNum+"번째 참가자 2번째 주사위게임 결과"+diceResult2+"가 나왔습니다.");
                score.totalScore[myNumber] = diceResult1 + diceResult2;

                //숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.


        }

    }

}

// 몇번째 판인지
//몇명 게임인지
//

//1. 주사위 게임을 만들어보자!

//총 2개의 주사위를 굴릴 수 있다.  -주사위
//첫 번째 주사위를 굴려서 짝수가 나왔다면 주사위를 한 번 더 굴릴 수 있다. - 주사위
//새롭게 한 번 더 굴리는 주사위에는 특수 기능들이 달려 있다.  -
//숫자 4가 나오는 경우 즉시 게임 오버된다.
//숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.
//숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.
//숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다.
//* 예외 사항으로 이미 0점인 친구 혹은 아직 주사위를 굴리지 않았다면 음수값을 가지지 않고 0점을 유지한다.
//이 상태에서 주사위의 합산값이 높은 사람이 이기도록 게임을 만들어보자!
//[출처] Java 문제 은행 [ 1 ] (에디로봇아카데미) | 작성자 링크쌤