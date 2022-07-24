package choijaemin.homework.entity.fourth;

public class Question2_Fibonacci {
    private int[] fibonacci = new int[20];



    public int fibonacciNum(){
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        return fibonacci[19];
    }
}
