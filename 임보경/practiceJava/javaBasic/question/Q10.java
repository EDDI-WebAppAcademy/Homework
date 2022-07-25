package javaBasic.question;

import javaBasic.utility.RandomUtil;

/*10. 1 ~ 100까지의 숫자를 순회한다.
     9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
     다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
     이동했을때 나온 숫자들의 합을 계산하도록 만들어보자!
*/
public class Q10 {
    private static RandomUtil ru = new RandomUtil();
    private static final int MAX = 10;
    private static final int MIN = 2;

    public void q10Solve() {
        int sum = 0;
        int end = 100;
        int cnt = 1;

        while(true) {
            int selectNum = ru.randomNumber(MAX, MIN);
            System.out.println(cnt++ +"번째 숫자는 " + selectNum);
            sum += selectNum;
            end -= selectNum;

            System.out.println("현재 랜덤으로 선택된 숫자의 합은 : " + sum);
            System.out.println("지금 나의 위치는 : " + (100 - end));
            System.out.println();

            if ((end - selectNum) < 2) {
                System.out.println("최종 합산 : " + sum);
                break;
            }
        }
    }


}
