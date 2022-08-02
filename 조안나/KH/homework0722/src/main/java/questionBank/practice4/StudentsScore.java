package questionBank.practice4;

public class StudentsScore {
    private int mathScore;
    private int engScore;
    private int korScore;

    public StudentsScore() {
    }

    /**
     * 입력 받은 과목 점수의 평균을 반환하는 메서드
     * @param mathScore 수학 점수
     * @param engScore 영어 점수
     * @param korScore 국어 점수
     * @return 85.33333333333333
     */
    public double ave(int mathScore, int engScore, int korScore) {
        this.mathScore = mathScore;
        this.engScore = engScore;
        this.korScore = korScore;
        return (double) (mathScore + engScore + korScore) / 3;
    }

    /**
     * 입력 받은 과목 점수의 분산 값을 반환하는 메서드
     * @param mathScore 수학 점수
     * @param engScore 영어 점수
     * @param korScore 국어 점수
     * @return
     */
    public double variance(int mathScore, int engScore, int korScore) {
        this.mathScore = mathScore;
        this.engScore = engScore;
        this.korScore = korScore;
        double ave = ave(mathScore, engScore, korScore);
        //과목 별 편차 구하기
        mathScore = (int) Math.pow(mathScore-ave, 2);
        engScore = (int) Math.pow(engScore-ave, 2);
        korScore = (int) Math.pow(korScore-ave, 2);

        return (mathScore + engScore + korScore) / 3;
    }


    /**
     * 력 받은 과목 점수의 표준편차 값을 반환 하는 메서드
     * @param mathScore 수학 점수
     * @param engScore 영어 점수
     * @param korScore 국어 점수
     * @return
     */
    public double standardDeviation(int mathScore, int engScore, int korScore) {
        this.mathScore = mathScore;
        this.engScore = engScore;
        this.korScore = korScore;
        return Math.pow(variance(mathScore, engScore, korScore), 2);
    }
}
