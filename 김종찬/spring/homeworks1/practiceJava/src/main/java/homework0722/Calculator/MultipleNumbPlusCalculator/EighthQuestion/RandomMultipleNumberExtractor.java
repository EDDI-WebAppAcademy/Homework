package homework0722.Calculator.MultipleNumbPlusCalculator.EighthQuestion;

import java.util.Random;


//  1 ~ 100까지 숫자를 순회한다.
//  2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.
public class RandomMultipleNumberExtractor {

    public static void main(String[] args) {
        System.out.println("2 ~ 10 사이의 랜덤한 숫자가 배정됩니다.");
        int num =  new Random().nextInt(10 - 2) + 2;
        System.out.println("숫자 " + num + "이 배정되었습니다.");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % num == 0) {
                sum += i;
            }
        }
        System.out.println("1부터 100까지 " + num +"의 배수의 합은 " + sum + "입니다.");
    }


}