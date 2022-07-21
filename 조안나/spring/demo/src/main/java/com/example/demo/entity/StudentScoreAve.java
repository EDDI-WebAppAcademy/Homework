package com.example.demo.entity;

import java.util.*;

public class StudentScoreAve {

    /**
     * 학생 30명에게 60점 이상의 임의의 점수를 랜덤하게 부여하고,
     * 학급의 평균 점수를 반환하는 메소드
     * @return 전체 학생 수 : 30명 / 학생 점수 총 합계 : 2422 / 학급 평균 점수 : 80.0
     */
    public String studentScoreAve(){
        HashMap<String, Integer> studentInfo = new LinkedHashMap<>();
        Random ran = new Random();
        int num = 1;
        while (true) {
        int studentScore = ran.nextInt(100) + 0;
            if(studentScore >= 60){
                studentInfo.put("학생" + num, studentScore);
                num++;
            }

            if (studentInfo.size() == 30){
                break;
            }
        }

        Set<String> set = studentInfo.keySet();
        Iterator<String> key_list = set.iterator();

        int scoreSum = 0;
        double scoreAve = 0;
        int allStudentNum = studentInfo.size();
        while (key_list.hasNext()){
            String key = key_list.next();
            scoreSum += studentInfo.get(key);
        }
            scoreAve = scoreSum / studentInfo.size();

        //콘솔에서 학생 1번부터 30번까지의 점수 확인 가능
        System.out.println(studentInfo);

        return String.format("전체 학생 수 : %d명 / 학생 점수 총 합계  : %d / 학급 평균 점수 : %.1f"
                ,allStudentNum, scoreSum, scoreAve);
    }
}

