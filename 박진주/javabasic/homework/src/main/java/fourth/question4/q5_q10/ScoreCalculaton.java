package fourth.question4.q5_q10;

public class ScoreCalculaton {

    public static void main(String[] args) {

        Student.inputName();      // 이름 입력 메소드 호출
        Score.inputScore();     // 점수 입력 메소드

        System.out.println( Student.name + "님의 수학, 영어, 국어 점수의 평균, 분산, 표준편차는 다음과 같습니다." );

        Score.avgCalculator();    // 평균 계산 메소드
        Score.varCalculator();    // 분산 계산 메소드
        Score.stdCalculator();    // 표준편차 계산 메소드














    }
}
