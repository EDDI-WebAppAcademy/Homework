package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.FibonacciNums;

public class Question3_Fibonacciapplication {
    private final int ARRAYCNT = 25;
    private int RoolPosition = 2;

    public int fibonacciApplication(){
        return FibonacciNums.fibonacci(ARRAYCNT,RoolPosition);
    }
}
