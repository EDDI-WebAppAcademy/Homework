package practice.bank4.quiz2;

import java.util.Scanner;

public class Score {
    private static int[] subjectScore = new int[3];
    private static double avg;
    private static double var;
    private static double std;

    public static void getScore(){
        Scanner sc = new Scanner(System.in);
        System.out.print("수학 점수 : ");
        subjectScore[0] = sc.nextInt();
        System.out.print("영어 점수 : ");
        subjectScore[1] = sc.nextInt();
        System.out.print("국어 점수 : ");
        subjectScore[2] = sc.nextInt();
    }


    public static double avg(){
        int sum = 0;
        for (int i = 0; i < subjectScore.length; i++) {
            sum += subjectScore[i];
        }
        double avg = (double) sum / subjectScore.length;
        return avg;
    }

    public static double var() {
    int sum = 0;
        for (int i = 0; i < subjectScore.length; i++) {
            sum += Math.pow(subjectScore[i] - avg, 2 );
        }

        double var = (double)sum / subjectScore.length;
        return var;
    }

    public static double sd() {
    double sd = Math.sqrt(var);
        return sd;
    }

}
