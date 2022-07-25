package kr.eddi.demo.entity.basic.fourth;

public class Q5_EVENNUMBER {
    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
        System.out.println("1부터 100까지의 숫자 중 짝수만 출력해보자!");
    }
}

