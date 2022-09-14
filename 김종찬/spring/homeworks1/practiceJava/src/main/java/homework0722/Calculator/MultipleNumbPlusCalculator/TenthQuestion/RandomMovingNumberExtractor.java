package homework0722.Calculator.MultipleNumbPlusCalculator.TenthQuestion;
//1 ~ 100까지의 숫자를 순회한다.
//9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
//다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
//이동했을때 나온 숫자들의 합을 계산하도록 만들어보자!

import java.util.Random;

public class RandomMovingNumberExtractor {

    public static void main(String[] args) {
        int str = 1; // 기준값
        int total = 0;

        while (true) {
            int num = new Random().nextInt(10 - 2) + 2;
            System.out.println(str +"에서 부터 "+ num + " 만큼 이동합니다.");
            str += num;
            System.out.println("지금 나의 위치는 " + str + "입니다.");
            total += str;
            System.out.println();

            if ((str+num) > 100) {
                total += str;
                System.out.println("최종 합산 : " + total);
                break;
            }
        }
    }
}