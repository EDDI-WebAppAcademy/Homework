package cls.i.lecture.day0726.entity;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class Score {

    private final int START_SCORE = 0;
    private Player player = new Player();
    public HashMap<Integer, Integer> playersScore = new HashMap<Integer, Integer>();

    public Score() {
        for(int i = 1; i <= player.getPlayerNum(); i++) {
            playersScore.put(i, START_SCORE);
        }

        log.info("점수판 초기화 : " + playersScore.toString() );
    }

    public String viewScore(){
        return playersScore.toString();
    }

    //0으로 초기화 (점수가 마이너스가 될때 사용하는 메소드)
    public void gotoZero (int playerKey, int recentScore) {
        recentScore = 0;
        playersScore.put(playerKey, recentScore);
    }

    //case 1 : 모두 다 2점씩 빼기. 단 0점이면 0점, 아직 주사위를 돌리지 않았다면(이조건은 나중에) 0점.
    public void takeScoreAllMember() {
        for(int i = 1; i <= player.getPlayerNum(); i++) {
            int recentScore = playersScore.get(i);

            if (recentScore > 0) {
                recentScore -= 2;
                playersScore.put(i, recentScore);
            }

            if (recentScore < 0) {
                gotoZero(i, recentScore);
            }
        }
    }

    //case 3 : 나를 제외하고 모두에게 뺏기 , 나는 더하기
    public void takeOtherMember(int activePalyer) {
        for(int i = 1; i <= player.getPlayerNum(); i++) {

            if (i != activePalyer) {
                int recentScore = playersScore.get(i);

                if (recentScore > 0) {
                    recentScore -= 3;
                    playersScore.put(i, recentScore);
                }

                if (recentScore < 0) {
                    gotoZero(i, recentScore);
                }

            // 나는 더하기
            } else {
                int getScore = (player.getPlayerNum() - 1) * 3;
                int recentScore = playersScore.get(activePalyer);
                recentScore += getScore;
                playersScore.put(activePalyer, recentScore);
            }
        }
    }

    //case 5 : 해당 플레이어를 제외한 모두에게 + 2점, 해당플레이어는  플레이어숫자  -1 * 2만큼 점수 빼기
    public void divideActivePlayerScore(int activePalyer) {
        for(int i = 1; i <= player.getPlayerNum(); i++) {

            if (i != activePalyer) {
                int recentScore = playersScore.get(i);

                recentScore += 2;
                playersScore.put(i, recentScore);

            } else {
                int minusScore = (player.getPlayerNum() - 1) * 2;
                int recentScore = playersScore.get(activePalyer);
                recentScore -= minusScore;

                if (recentScore < 0) {
                    gotoZero(activePalyer, recentScore);
                }

                playersScore.put(activePalyer, recentScore);
            }
        }
    }


    boolean isWinner = false;
    public boolean isWinner () {
        int[] compareScore = new int[player.getPlayerNum()];
        for (int i = 1; i <= player.getPlayerNum(); i++){
            compareScore[i - 1] = playersScore.get(i);
        }

        //모두가 동일한 값일때.
        for (int i = 1; i <= player.getPlayerNum(); i++){
            if (compareScore[0] == compareScore[i]) {
                return true;
            }
        }
        return false;
    }
    //
}
