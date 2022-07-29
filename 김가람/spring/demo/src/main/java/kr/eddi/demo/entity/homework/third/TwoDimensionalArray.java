package kr.eddi.demo.entity.homework.third;

public class TwoDimensionalArray {

    private int[][] randomArr;

    public TwoDimensionalArray(int idx1, int idx2) {
        randomArr = new int[idx1][idx2];
    }

    public String makeTwoDimensionalArray() {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < randomArr.length; i++) {
            for (int j = 0; j < randomArr[i].length; j++) {
                randomArr[i][j] = num++;
            }
        }
        for (int i = 0; i < randomArr.length; i++) {
            for (int j = 0; j < randomArr[i].length; j++) {
                sb.append(randomArr[i][j]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
