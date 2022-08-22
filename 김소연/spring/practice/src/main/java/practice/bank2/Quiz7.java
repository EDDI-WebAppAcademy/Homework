package practice.bank2;

public class Quiz7 {
    //1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
    public static void main(String[] args) {
        multiples(4);
    }

    public static void multiples(int n){
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(i % n ==0){
                sum += i;
            }
        }
        System.out.println("1 ~ 100까지 숫자중 " + n + "의 배수를 더한 결과: " + sum);
    }
}
