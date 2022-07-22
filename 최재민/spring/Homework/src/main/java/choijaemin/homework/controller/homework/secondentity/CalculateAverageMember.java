package choijaemin.homework.controller.homework.secondentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateAverageMember {
    private int maxScore = 110-10;         // 최대점수
    private int minScore = 60;          // 최소점수
    private int totalScore = 0;         // 총합계
    private double average = 0;         // 평균
    final private int studentCnt =30;   // 학생수

}
