package homework0722.Ninth;

import java.util.Random;

// 1 ~ 100까지의 숫자를 순회한다.
// 2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
// 다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
// 그 다음 루프에서 다시 작업을 반복한다.
// 끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
// 3번 반복?
public class NinthQuestion {

    public static void main(String[] args) {

        int total = 0; // 합계
        int roop = 3; //반복 횟수
        int cnt = 1;
        int MAX = 100; // 최댓값

        while(true) {
            int num =  new Random().nextInt(10 - 2) + 2;
            int sum = 0;
            System.out.println(cnt + "번째 배수 " + num + "이 배정되었습니다.");
            for (int i = 1; i <= MAX ; i++) {
                if (i % num == 0) {
                    sum += i;
                }
            }

            total += sum;
            System.out.println(cnt+"번째 배수의 총 합은: "+ sum + " 입니다.");
            cnt++;
            roop -= 1;


            // roop 값이 0이 될 경우 종료
            if (roop <= 0) {
                System.out.println("출력된 숫자들의 총 합은 " + total + "입니다.");
                break;
            }
        }
    }


}

