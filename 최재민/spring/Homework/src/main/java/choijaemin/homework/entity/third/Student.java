package choijaemin.homework.entity.third;

import choijaemin.homework.utility.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {
    SumScore sumScore;
    private int studentCnt = 0;
    private final int MAX = 30;
    private final int MIN = 10;

    // 학생들의 수를 랜덤하게 받는 메서드
    public int randomStudentCnt(){
        return studentCnt = CustomRandom.makeIntCustomNum(MIN , MAX);
    }


    public String showSumAverage(){
        AverageScore averageScore =new AverageScore();
        averageScore.AverageScore();
        String showmainText =  String.format("총점: %d, 평균 점수: %.1f ,학생의 수 : %d",
                averageScore.getTotalScore(),averageScore.getAverage(),averageScore.getStudentCnt());

        return showmainText;
    }
}
