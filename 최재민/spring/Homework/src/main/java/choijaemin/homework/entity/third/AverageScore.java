package choijaemin.homework.entity.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AverageScore {

    private int totalScore;
    private double average;
    private int studentCnt;
    SumScore sumScore = new SumScore();


    public void  AverageScore(){
        this.totalScore = sumScore.sumScore();
        this.studentCnt = sumScore.studentCnt;
        this.average = ((double) totalScore/studentCnt);

    }


}
