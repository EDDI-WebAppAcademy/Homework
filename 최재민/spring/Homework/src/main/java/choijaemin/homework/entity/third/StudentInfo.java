package choijaemin.homework.entity.third;

import choijaemin.homework.utility.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class StudentInfo {

    private HashMap<String,Integer> studentInfom = new LinkedHashMap<>();
    private final int MAX = 100;
    private final int MIN = 0;
    Student student= new Student();
    int studentCnt = student.randomStudentCnt();

    public void studentInfo1(){
        for (int i = 0; i <= studentCnt; i++) {
            int randomScore = CustomRandom.makeIntCustomNum(MIN,MAX);
            studentInfom.put((String)(i +"student"),randomScore);
        }

    }

    // 최저점을 설정하기 위한 오버로드
    public void studentInfo1(int min){
        int studentCnt = student.randomStudentCnt();
        for (int i = 0; i < studentCnt; i++) {
            int randomScore = CustomRandom.makeIntCustomNum(min,MAX);
            studentInfom.put((String)(i +"student"),randomScore);
        }

    }
}
