package kr.eddi.demo.quizBank2;

public class Ex7 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                sum += i;
                System.out.println("결과 : " + i);
                System.out.println("합 : " + sum);
                //System.out.println(sum);
            }
        }
    }
}
