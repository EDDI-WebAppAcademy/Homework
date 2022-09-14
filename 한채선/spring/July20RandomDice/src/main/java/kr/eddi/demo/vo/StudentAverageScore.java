package kr.eddi.demo.vo;

import kr.eddi.demo.controller.dto.TotalAverage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
public class StudentAverageScore {

    private TotalAverage totalAverage;
    private Random random;
    private ArrayList<Integer> scoreList;

    public StudentAverageScore() {
        totalAverage = new TotalAverage();
        random = new Random();
        scoreList = new ArrayList<>();
    }

    public StudentAverageScore(int size) {
        totalAverage = new TotalAverage();
        random = new Random();
        scoreList = new ArrayList<>(size);
    }

    /**
     * 테스트 점수 목록을 만드는 메서드
     */
    public void addScoreList(){
        random = new Random();
        for (int i = 0; i < 30; i++) {
            scoreList.add(random.nextInt(60, 101));
        }
        log.info(String.valueOf(scoreList));
    }

    /**
     * 점수 목록의 총합을 구하는 메서드
     */
    public int calcTotalScore(){
        int totalScore = totalAverage.getTotalScore();
        for (int score : scoreList) {
            totalScore += score;
        }
        totalAverage.setTotalScore(totalScore);
        return totalAverage.getTotalScore();
    }

    /**
     * 평균 점수를 구하는 메서드
     */
    public double calcAverageScore(){
        int studentNum = scoreList.size();
        double aveScore = (double) totalAverage.getTotalScore() / studentNum;
        totalAverage.setAveScore(aveScore);
        return totalAverage.getAveScore();
    }
}
