package homework0722.Sixth;
//1 ~ 100까지 숫자중 3의 배수만 출력해보자!


import java.util.Scanner;

public class SixthQuestion {
        public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("최소 값을 입력해주세요");
        int N = in.nextInt();
        int[] MIN = new int[N];

        System.out.println("최대 값을 입력해주세요");
        int M = in.nextInt();
        int[] MAX = new int[M];

        System.out.println("배수를 입력해주세요");
        int T = in.nextInt();
        int[] MULTI = new int[T];


        System.out.println("최소 값 " + N + " 부터 " + M + "까지 숫자 중 " + T +" 의 배수는 다음과 같습니다.");
        for (int i = N; i <= M; i++) {
            if (i % T == 0) {
                System.out.println(i);
            }
        }


    }
    }

