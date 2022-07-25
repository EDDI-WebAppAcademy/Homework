package homework0722.Fifth;

import java.util.Scanner;

//1 ~ 100까지 숫자중 짝수만 출력해보자
public class FifthQuestuon {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("최소 값을 입력해주세요");
        int N = in.nextInt();
        int[] MIN = new int[N];

        System.out.println("최대 값을 입력해주세요");
        int M = in.nextInt();
        int[] MAX = new int[M];


        System.out.println("최소 값 " + N + " 부터 " + M + "까지 숫자 중 짝수는 다음과 같습니다.");
        for (int i = N; i <= M; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }


    }
}
