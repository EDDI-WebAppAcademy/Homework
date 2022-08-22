package practice.bank2;

public class Quiz10 {
    /*
    *  1 ~ 100까지의 숫자를 순회한다.
     9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
     다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
     이동했을때 나온 숫자들의 합을 계산하도록 만들어보자!
    * */
    public static void main(String[] args) {
        int ranNum = getRandomNum(2,10);
        System.out.println("랜덤 숫자 : " + ranNum);
        int totalSum = randomPlusSum(ranNum);
        System.out.println("이동했을 때 나온 숫자들의 합: "+ totalSum);

    }


    public static int getRandomNum(int min, int max){
        int ranNum = (int) (Math.random() * (max - min + 1) + min);
        return ranNum;
    }


    public static int randomPlusSum(int n) {
        int totalSum = 0;
        for (int i = 1; i <= 100;) {
            i += n;
            totalSum += i;
            }
        return totalSum;
    }
}
