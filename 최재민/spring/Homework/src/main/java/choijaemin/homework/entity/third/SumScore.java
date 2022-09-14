package choijaemin.homework.entity.third;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class SumScore {

    // 모든 학생의 점수의 총합을 구하는 메서드
    private int totalScore = 0;
    StudentInfo studentInfo = new StudentInfo();
    int studentCnt;
    public int sumScore() {
        studentInfo.studentInfo1(60);
        this.studentCnt = studentInfo.getStudentInfom().size();
        Set<String> set = studentInfo.getStudentInfom().keySet();
        Iterator<String> key_list = set.iterator();
        totalScore = 0;
        while (key_list.hasNext()) {
            String key = key_list.next();
            totalScore += studentInfo.getStudentInfom().get(key);
        }

        return totalScore;
    }


    // 점수의 평균을 구하는 메서드



}
