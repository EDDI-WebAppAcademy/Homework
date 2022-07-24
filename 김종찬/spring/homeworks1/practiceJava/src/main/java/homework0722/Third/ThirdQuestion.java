package homework0722.Third;

//    1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
//    이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!

import java.util.Scanner;

public class ThirdQuestion {
    //나라야나의 소 수열
    // a(0) = 1, a(1) = 2, a(2) = 3, 그 이후 부터 a(n) = a(n-1) + a(n-3)

        public static void main (String[]args){
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();

            int[] nara = new int[N + 1];    // F(0) 부터 시작하므로 N + 1 크기 생성

            for(int i = 1; i < nara.length; i++) {
                // 3번째 항까지 값은 1로 고정
                if(i < 3) nara[i] = 1;
                // 이후부터 수열 공식 적용으로 인해 아래 값으로 출력
                else  nara[i] = nara[i - 1] + nara[i - 3];}

            System.out.println(N + "번째 나라나야의 소 수열의 값은 " + nara[N] + " 입니다.");


                    }
            }






