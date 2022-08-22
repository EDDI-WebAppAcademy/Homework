package practice.bank2;

public class Quiz6 {
    //1 ~ 100까지 숫자중 3의 배수만 출력해보자!
    public static void main(String[] args) {
        multiples(3);
    }

    public static void multiples(int n){
        for (int i = 1; i <= 100; i++) {
            if(i % n == 0){
                System.out.print(i + " ");
            }
        }
    }
}
