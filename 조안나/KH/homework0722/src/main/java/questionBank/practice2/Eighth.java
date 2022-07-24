package questionBank.practice2;

import java.util.ArrayList;
import java.util.Random;

public class Eighth {
//    8. 1 ~ 100까지 숫자를 순회한다.
//       2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.

    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {

        allMultiple();
    }

    /**
     * multipleNum메서드에서 랜덤한 숫자 ranNum을 부여 받고,
     * number배열에서 ranNum의 배수인 숫자를 ArrayList<Integer> allMultiple에 저장한다.
     * @return ArrayList<Integer> allMultiple 값을 반환
     */
    public static ArrayList<Integer> allMultiple(){
        ArrayList<Integer> allMultiple = new ArrayList<>();
        int ranNum = multipleNum(2, 10);
        System.out.print(ranNum + "의 배수 : ");
        for (int i = MIN; i < allNumber().length; i++) {
            if (allNumber()[i] % ranNum == 0){
                allMultiple.add(i);
                System.out.print(i + " ");
            }
        }
        return allMultiple;
    }

    /**
     * MIN부터 MAX까지의 모든 숫자를 int배열 number에 저장
     * @return int배열 number 반환
     */
    public static int[] allNumber(){
        int[] number = new int[MAX + 1];
        for (int i = MIN; i < MAX + 1; i++) {
            number[i] = i;
        }
        return number;
    }

    /**
     * 범위를 입력하면 그 범위 안에서 랜덤한 값을 반환하는 메서드.
     * @param min 범위 시작 값
     * @param max 범위 마지막 값
     * @return 범위 사이의 랜덤한 수 반환
     */
    public static int multipleNum(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max+1);
    }
}
