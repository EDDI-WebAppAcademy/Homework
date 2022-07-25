package practice.bank2;

public class Quiz2 {
    /*
    * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!
    * */
    public static void main(String[] args) {
        int num = 20;
        System.out.print("피보나치 수열의 " +num+ "번째 항 : " + fibo(num));
    }

    public static int fibo(int num){
        if(num <= 1){
            return num;
        }else {
            return fibo(num-2) + fibo(num-1);
        }
    }
}
