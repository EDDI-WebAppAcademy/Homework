package questionBank.practice2;

public class Fifth {

//    5. 1 ~ 100까지 숫자중 짝수만 출력해보자

    private static final int MIN = 1;
    private static final int MAX = 100;
    public static void main(String[] args) {

        System.out.println( MIN + "부터 " + MAX + "까지의 숫자중 짝수를 출력합니다.");
        for (int i = MIN; i <= MAX; i++) {
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }
}
