package practice.bank2;

public class Quiz8 {
    //1 ~ 100까지 숫자를 순회한다
    //2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.

    public static void main(String[] args) {
        multiples(getRandomNum(2,10));
    }

    public static int getRandomNum(int min, int max){
        int ranNum = (int) (Math.random() * (max - min + 1) + min);
        return ranNum;
    }

    public static void multiples(int n){
        for (int i = 1; i <= 100; i++) {
            if(i % n == 0){
                System.out.print(i + " ");
            }
        }
    }
}
