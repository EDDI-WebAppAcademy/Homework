package questionBank.javaPractice1.entity;

import java.util.ArrayList;

public class PlayUser {


    /**
     * 입력받은 유저의 수만큼 스타트 점수를 부여해주는 메서드
     * @param PLAY_USER_NUM 플레이하는 유저 수
     * @return 유저 수 만큼 지정된 점수를 int형 ArrayList 반환
     */
    public static ArrayList<Integer> playUserNum(int PLAY_USER_NUM, int START_SCORE){
        ArrayList<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < PLAY_USER_NUM; i++) {
            userNum.add(START_SCORE);
        }
        return userNum;
    }

    /**
     * 유저들의 점수 중 최고점을 찾아주고, 최후 WINNER를 알려주는 메소드
     * @param userNum user들의 score를 담은 int형 ArrayList
     * @return 유저 중 가장 큰 점수는 ? 17 / WINNER : 1번 USER
     */
    public static String userScoreSum(ArrayList<Integer> userNum){

        return "유저 중 가장 큰 점수는 ? " + Score.winnerScoreFind(userNum) + "\n" +
                "WINNER : " + (userNum.indexOf(Score.winnerScoreFind(userNum)) + 1) + "번 User!!";
    }
}
