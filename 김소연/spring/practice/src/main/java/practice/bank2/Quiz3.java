package practice.bank2;

public class Quiz3 {
    /*
     * 1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
     * 이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!
     * */
    public static void main(String[] args) {
        int num = 25;
        System.out.print("수열의 " + num + "번째 항 : " + sequence(num));
    }

    public static int sequence(int num) {
        if (num <= 3) {
            return 1;
        } else {
            return sequence(num - 3) + sequence(num - 1);
        }
    }
}
