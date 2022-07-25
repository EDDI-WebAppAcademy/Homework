package choijaemin.homework.entity.fourth;

import choijaemin.homework.utility.fourth.FibonacciNums;

public class Question2_Fibonacci {
    private final int ARRAYCNT = 20;
    private int RoolPosition = 1;


    public int fibonacciNum(){
        return FibonacciNums.fibonacci(ARRAYCNT,RoolPosition);
    }
}
