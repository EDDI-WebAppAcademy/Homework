package lbk.homework.day0725.makeMethodwithClass.entity;

public class Series {

    private int[] seriesArr;
    private final int FIBONACCI = 1;
    private final int CUSTOM = 2;

    public Series(int length) {
        seriesArr = new int[length];
    }

    public void divideSeries(int seriesNum) {
        if (seriesNum == FIBONACCI) {
            makeFibonacciSeries();
        } else if (seriesNum == CUSTOM) {
            makeCustomSeries();
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public void makeFibonacciSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;

        for (int i = 2; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[ i - 1 ] + seriesArr[ i - 2 ] ;
        }
    }

    public void makeCustomSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;
        seriesArr[2] = 1;

        for (int i = 3; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 1] + seriesArr[i - 3];
        }
    }

    public int acquireSpecificNum() {
        return seriesArr[seriesArr.length - 1];
    }

}
