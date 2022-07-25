package kr.eddi.demo.vo;

public class MainTextRun {

    private StudentAverageScore stuAveScore;

    public MainTextRun() {
        stuAveScore = new StudentAverageScore(30);
    }

    /**
     * 메인 화면에 출력될 텍스트 메서드
     * @return 메인 화면에 출력되는 String
     */
    public String showTotalAndAverage(){
        stuAveScore.addScoreList();
        int total = stuAveScore.calcTotalScore();
        double average = stuAveScore.calcAverageScore();
        String mainText = String.format("테스트 점수 총점: %d, 평균: %f", total, average);
        return mainText;
    }
}
