package kr.eddi.demo.practice;

import java.util.Random;

public class Ninth {

    public static void main(String[] args) {

        int total = 0;
        int cnt = 1;
        int max = 100;

        while(true){

            int sum = 0;
            Random random = new Random();
            int num = random.nextInt(2,10);

            for (int i = 1; i <= max; i++) {
                if (i % num == 0) {
                    sum += i;
                }
            }
            System.out.println(cnt + "번째 배수의 합은 "+ sum + " 입니다.");

            total += sum;
            cnt ++;

            if(max - cnt < 0){
                System.out.println("출력된 숫자들의 합은 " + total + " 입니다.");
                break;
            }
        }
    }
}
