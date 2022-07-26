package kr.eddi.demo.entity.homework.fifth;

import lombok.Getter;

@Getter
public class SeriesHomework {
    private final int FIBO_S = 1;
    private final int CSTM_S = 2;
    private int[] seriesArr;

    public SeriesHomework(int seriesNum, int length) {
        seriesArr = new int[length];

        if (seriesNum == FIBO_S) {
            makeFibo();
        } else if (seriesNum == CSTM_S) {
            makeCstm();
        } else {
            System.out.println("잘못된 정보입니다.");
        }
    }

    public void makeFibo() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;

        for (int i = 2; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 1] + seriesArr[i - 2];
        }
    }

    public void makeCstm() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;
        seriesArr[2] = 1;
        seriesArr[3] = 2;

        for (int i = 4; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 2] + seriesArr[i - 3] + seriesArr[i - 4];
        }
    }
    public int findSeriesNum(){
        return seriesArr[seriesArr.length-1];
    }
}
