package questionBank.practice2;

public class Sixth {

//6. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int NUM = 3;
    public static void main(String[] args) {

        System.out.println( MIN + "부터 " + MAX + "까지의 숫자중 " + NUM + "의 배수를 출력합니다.");
        for (int i = MIN; i <= MAX; i++) {
            if(i % NUM == 0){
                System.out.print(i + " ");
            }
        }
    }
}
