package fourth.question4.q5_q10;

import java.util.Scanner;

public class Score {

    //public static void main(String[] args) {

//        System.out.println("이름을 입력해주세요 : ");  // 이름 입력 메소드
//        Student.name = sc.nextLine();

    private static int[] subScore = new int[3];
    private static double average;
    private static double var;
    private static double std;

       // 점수 입력 메소드
       public static void  inputScore(){
           Scanner sc = new Scanner(System.in);

           System.out.println("수학 점수 입력 : ");
           subScore[0] = sc.nextInt();
           System.out.println("영어 점수 입력 : ");
           subScore[1] = sc.nextInt();
           System.out.println("국어 점수 입력 : ");
           subScore[2] = sc.nextInt();
       }

       // 평균 계산 메소드
       public static void avgCalculator() {
           average = (double)(subScore[0] + subScore[1]+ subScore[2])/ Student.subject.length;
           System.out.println("평균: "+ average);
       }


       //분산 계산 메소드 (= 편차제곱의 평균)
       public static void varCalculator() {
           double devSqSum = 0.0;

           for (int i = 0; i < subScore.length ; i++) {
               double devSquare = (double) (subScore[i]- average) * (subScore[i]- average);

               devSqSum += devSquare;
           }
          var = devSqSum/ subScore.length;
           System.out.println("분산: " + var);
    }

       // 표준편차 계산 메소드
       public static void stdCalculator() {
          std = Math.sqrt(var);
           System.out.println("표준편차: " + std);
       }


   // }




}



//5. 학생 클래스를 만들어봅시다.
//6. 학생 클래스에 수학, 영어, 국어 점수를 입력 받도록 개조합니다.
//7. 학생 클래스의 평균을 계산해봅시다.
//8. 주사위 클래스를 만들어봅시다.
//9. 7번 문제에서 분산을 구해봅시다.
//10. 7번 문제에서 표준 편차를 구해봅시다.
//[출처] 문제 은행 [ 4 ] (에디로봇아카데미) | 작성자 링크쌤