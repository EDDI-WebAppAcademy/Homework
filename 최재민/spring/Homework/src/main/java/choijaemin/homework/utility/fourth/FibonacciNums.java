package choijaemin.homework.utility.fourth;

public class FibonacciNums {
    public static int fibonacci(int arrayCnt, int Position){
        int[] fibonacci = new int[arrayCnt];

        for (int i = 0; i <= Position; i++) {
            fibonacci[i] = 1;
        }

        for (int i = (Position+1); i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-(Position+1)];
        }

        return fibonacci[fibonacci.length - 1];
    }
}
