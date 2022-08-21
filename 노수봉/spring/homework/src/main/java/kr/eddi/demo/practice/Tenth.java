package kr.eddi.demo.practice;

import java.util.Random;

public class Tenth {
    public static void main(String[] args) {

        int sum = 0;
        int max = 100;
        int cnt = 1;

        while(true){
            Random random = new Random();
            int num = random.nextInt(2,10);

            System.out.println(cnt + "번째 이동거리는 " + num +" 입니다.");

            sum += num;
            cnt ++;

            if(max - cnt < 0){
                System.out.println("이동한 거리의 합은 " + sum + " 입니다.");
                break;
            }
        }

    }
}
