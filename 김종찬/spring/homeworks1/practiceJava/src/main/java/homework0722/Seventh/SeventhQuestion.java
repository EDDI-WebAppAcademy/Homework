package homework0722.Seventh;

import java.util.Scanner;

// 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class SeventhQuestion {
    public static void main(String[] args) {
        int sum = 0;

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


        System.out.println("최소 값 " + N + " 부터 최대 값 " + M + "까지 숫자 중 " + T +" 의 배수를 더한 값은 다음과 같습니다.");

        for (int i = N; i <= M; i++) {
            if (i % T == 0) {
                sum += i;

            }
        }System.out.println(sum);



    }
}