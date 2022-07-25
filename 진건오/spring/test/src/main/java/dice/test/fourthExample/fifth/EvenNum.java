package dice.test.fourthExample.fifth;


public class EvenNum {
    private static int MAX = 100;

    public static void main(String[] args) {
        for (int i = 1; i <= MAX; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}