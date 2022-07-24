package fourth.question4.q5_q10;

import static fourth.question4.q5_q10.Score.*;
import static fourth.question4.q5_q10.Student.inputName;

public class ScoreCalculaton {

    public static void main(String[] args) {

        inputName();      // 이름 입력 메소드 호출
        inputScore();     // 점수 입력 메소드

        System.out.println( Student.name + "님의 수학, 영어, 국어 점수의 평균, 분산, 표준편차는 다음과 같습니다." );

        avgCalculator();    // 평균 계산 메소드
        varCalculator();    // 분산 계산 메소드
        stdCalculator();    // 표준편차 계산 메소드














    }
}
