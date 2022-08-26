package questionBank.javaPractice1.entity;

import java.util.ArrayList;

public class Players {

    /**
     * 입력받은 플레이어의 수만큼 스타트 점수를 부여해주는 메서드
     * @param PLAY_USER_NUM 플레이어 수
     * @return 플레이어들의 기본 점수를 저장한 int형 ArrayList 반환
     */
    public static ArrayList<Integer> playersScore(int PLAY_USER_NUM, int START_SCORE){
        ArrayList<Integer> playersScore = new ArrayList<>();
        for (int i = 0; i < PLAY_USER_NUM; i++) {
            playersScore.add(START_SCORE);
        }
        return playersScore;
    }

    /**
     * 플레이어들의 점수 중 최고점을 찾아주고, 최후 WINNER를 알려주는 메소드
     * @param playersScore players score를 담은 int형 ArrayList
     * @return 유저 중 가장 큰 점수는 ? 17 / WINNER : 1번 Player!!
     */
    public static String userScoreSum(ArrayList<Integer> playersScore){

        return "유저 중 가장 큰 점수는 ? " + Score.winnerScoreFind(playersScore) + "\n" +
                "WINNER : " + (playersScore.indexOf(Score.winnerScoreFind(playersScore)) + 1) + "번 Player!!";
    }
}
