package practice.bank2;

import java.util.ArrayList;

public class Quiz9 {
    /*
    * 1 ~ 100까지의 숫자를 순회한다.
    2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
    다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
    그 다음 루프에서 다시 작업을 반복한다.
    끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
    * */
    public static void main(String[] args) {
        ArrayList<Integer> multipleArr = new ArrayList<>();

        int sum = 0;
        int totalSum = 0;
        int cnt = 0;

        for (int i = 1; i <= 3; i++) {
            int randomNum = getRandomNum(2, 10);
            System.out.println("랜덤숫자 선택: " + randomNum);
            multipleArr = multiples(randomNum);
            System.out.println();
            for (int j = 0; j < multipleArr.size(); j++) {
                sum += multipleArr.get(j);
            }
        }
        totalSum += sum;
        System.out.println("출력된 숫자들의 합 : " + totalSum);
    }


    public static int getRandomNum(int min, int max){
        int ranNum = (int) (Math.random() * (max - min + 1) + min);
        return ranNum;
    }

    public static ArrayList<Integer> multiples(int n){
        ArrayList<Integer> multipleArray = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if(i % n == 0){
                System.out.print(i + " ");
                multipleArray.add(i);
            }
        }
        return multipleArray;
    }


}
