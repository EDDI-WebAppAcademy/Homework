package practice.bank2;

public class Quiz4 {
    //구구단 7단을 출력해보자!
    public static void main(String[] args) {
        gugudan(7);
    }

    public static void gugudan(int n){
        System.out.println( "==== " + n + "단 ====");
        for (int i = 1; i < 10; i++) {
            System.out.println(n + " * "+ i + " = " + (n * i));
        }
    }
}
