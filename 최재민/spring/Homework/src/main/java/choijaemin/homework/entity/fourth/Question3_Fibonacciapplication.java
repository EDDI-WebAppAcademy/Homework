package choijaemin.homework.entity.fourth;

public class Question3_Fibonacciapplication {
    private int[] fibonacci = new int[25];

    public int fibonacciApplication(){
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-3];
        }

        return fibonacci[24];
    }
}
