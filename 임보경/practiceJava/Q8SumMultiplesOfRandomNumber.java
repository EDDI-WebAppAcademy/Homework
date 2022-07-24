package javaBasic;

import java.util.Random;

public class Q8SumMultiplesOfRandomNumber {

    public static void main(String[] args) {

        System.out.println(
                "1 ~ 100까지 숫자를 순회한다.\n" +
                "2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다."
        );

        int selectNum = randomNumber();
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % selectNum == 0) {
                sum += i;
            }
        }
        System.out.println("내가 선택한 숫자는 : " + selectNum);
        System.out.println("선택한 숫자의 배수의 합은(range 1~100) : " + sum);
    }

    public static int randomNumber() {
        return new Random().nextInt(10 - 2) + 2;
    }

}
