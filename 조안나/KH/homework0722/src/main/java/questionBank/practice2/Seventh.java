package questionBank.practice2;

public class Seventh {

//    7. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int NUM = 4;
    public static void main(String[] args) {


        int sum = 0;
        System.out.println( MIN + "부터 " + MAX + "까지의 숫자중 " + NUM + "의 배수의 합을 출력합니다.");
        for (int i = MIN; i <= MAX; i++) {
            if(i % NUM == 0){
                System.out.print(i + " ");
                sum = sum + i ;
            }
        }
        System.out.println();
        System.out.println("sum = " + sum );
    }
}
