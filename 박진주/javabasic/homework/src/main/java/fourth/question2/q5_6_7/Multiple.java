package fourth.question2.q5_6_7;

public class Multiple{
    private static final int min = 1;
    private static final int max = 100;


    // 5번, 6번 문제 - 배수 출력 메소드
    public static void CalcMultiple(int num){
        System.out.println( min +"과 "+ max +" 범위 내에 " + num + "의 배수는 다음과 같습니다.");

        for (int i = min; i <= max; i++) {
            if ((i % num) == 0) {
                System.out.println(i);
            }
        }
    }

    // 7번 문제- 배수 합 출력 메소드
    public static void CalcMultipleSum(int num){
        int sum = 0;

        for (int i = min; i <= max; i++) {
            if ((i % num) == 0) {
                sum += i;
            }
        }
        System.out.println(min +"과 "+ max +" 범위 내에 " + num + "의 배수 합은 " +sum+ "입니다.");
    }


}

//5. 1 ~ 100까지 숫자중 짝수만 출력해보자.
//6. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
//7. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
//[출처] 문제 은행 [ 2 ] (에디로봇아`카데미) | 작성자 링크쌤