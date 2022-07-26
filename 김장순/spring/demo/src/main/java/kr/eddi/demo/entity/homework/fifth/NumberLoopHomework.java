package kr.eddi.demo.entity.homework.fifth;

public class NumberLoopHomework {
    private int start;
    private int end;

    public NumberLoopHomework(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public String simpleFinder(int condition) {
        String msg = "";

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }
}
