package kr.eddi.demo.entity.homework.fourth;

public class Sequence {

    private final int FIBONACCI_SEQUENCE = 1;
    private final int SUPER_GOLDEN_SEQUENCE = 2;
    private int[] sequenceArr;

    public Sequence(int SequenceNum, int length) {
        sequenceArr = new int[length];

        if (SequenceNum == FIBONACCI_SEQUENCE) {
            makeFibonacciSequence();
        } else if (SequenceNum == SUPER_GOLDEN_SEQUENCE) {
            makeSuperGoldonSequence();
        } else {
            System.out.println("잘못된 정보입니다.");
        }
    }

    public void makeFibonacciSequence() {
        sequenceArr[0] = 1;
        sequenceArr[1] = 1;

        for (int i = 2; i < sequenceArr.length; i++) {
            sequenceArr[i] = sequenceArr[i - 1] + sequenceArr[i - 2];
        }
    }

    public void makeSuperGoldonSequence() {
        sequenceArr[0] = 1;
        sequenceArr[1] = 1;
        sequenceArr[2] = 1;

        for (int i = 3; i < sequenceArr.length; i++) {
            sequenceArr[i] = sequenceArr[i - 3] + sequenceArr[i - 1];
        }
    }
    public int findSequenceNum() {
        return sequenceArr[sequenceArr.length - 1];
    }
}
