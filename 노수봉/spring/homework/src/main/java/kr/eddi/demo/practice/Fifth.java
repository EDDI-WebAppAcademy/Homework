package kr.eddi.demo.practice;

public class Fifth {
    public static void main(String[] args) {
        System.out.println("1부터 100까지의 숫자 중 짝수만 출력해보자!");
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
