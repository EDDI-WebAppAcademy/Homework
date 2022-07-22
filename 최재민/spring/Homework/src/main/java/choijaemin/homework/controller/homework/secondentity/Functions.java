package choijaemin.homework.controller.homework.secondentity;

import java.util.*;

public class Functions {// 기능 클래스
    CalculateAverageMember member = new CalculateAverageMember();
    int totalScore = member.getTotalScore();
    double average = member.getAverage();
    int studentCnt = member.getStudentCnt();
    int maxScore = member.getMaxScore();
    int minScore = member.getMinScore();
    HashMap<String,Integer> studentInfom = new LinkedHashMap<>();
    /*
    각각의 학생의 고유 번호를 부여하고
    점수를 부여하는 메서드
     */
     public void studentInfo(){
        Random random = new Random();
         int cnt = 0;
        while (true){
            int randmoScore = random.nextInt(minScore,maxScore);
            studentInfom.put((String)(cnt +"student"),randmoScore);
            cnt++;

            if(studentInfom.size() == studentCnt) break;
        }
    }

    /*
    점수의 합계를 구하는 메서드
     */
    public int sumScore(){
        Set<String> set = studentInfom.keySet();
        Iterator<String> key_list = set.iterator();
        totalScore = 0;
        while (key_list.hasNext()){
            String key = key_list.next();
            totalScore += studentInfom.get(key);
        }

        return totalScore;
    }

    /*
    점수의 평균을 구하는 메서드
     */
    public double aveScore(){
        average = ((double) sumScore()/studentCnt);
        return average;
    }

    /*
       출력을 하기 위한 메서드
        */
    public String showSumAverage(){
        String showmainText =  String.format("점수 평균: %.1f, 총점: %d", aveScore(),sumScore());

        return showmainText;
    }
}
