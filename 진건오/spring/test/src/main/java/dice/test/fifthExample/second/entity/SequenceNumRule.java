package dice.test.fifthExample.second.entity;

public class SequenceNumRule {


    private final int fibonacciToken = 1;
    private final int customSequenceToken = 2;

    private int[] sequenceNumArr;

    public SequenceNumRule(int num, int range) {
        sequenceNumArr = new int[range];

        if (num == fibonacciToken) {
            doFibonacci();
        } else if (num == customSequenceToken) {
            doCustomSequence();
        }
    }

    public void doFibonacci() {
        sequenceNumArr[0] = 1;
        sequenceNumArr[1] = 1;

        for (int i = 2; i < sequenceNumArr.length; i++) {
            sequenceNumArr[i] = sequenceNumArr[i - 1] + sequenceNumArr[i - 2];
        }
    }

    public void doCustomSequence() {
        sequenceNumArr[0] = 1;
        sequenceNumArr[1] = 1;
        sequenceNumArr[2] = 1;

        for (int i = 3; i < sequenceNumArr.length; i++) {
            sequenceNumArr[i] = sequenceNumArr[i - 1] + sequenceNumArr[i - 3];
        }
    }

    public int findByNum() {
        return sequenceNumArr[sequenceNumArr.length - 1];
    }
}
