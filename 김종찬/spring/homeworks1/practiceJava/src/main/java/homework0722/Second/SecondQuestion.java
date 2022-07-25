package homework0722.Second;


import java.util.Scanner;

//    2. 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//    일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!
public class SecondQuestion {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] fibonacci = new int[N+1];	// F(0) 부터 시작하므로 N + 1 크기 생성

        for(int i = 1; i < fibonacci.length; i++) {
            // 1항의 값은 1로 고정
          if(i == 1) fibonacci[1] = 1;
            else fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];

        }
        System.out.println(N + "번째 피보나치 수열의 값은 "+ fibonacci[N]+ " 입니다.");


    }
}