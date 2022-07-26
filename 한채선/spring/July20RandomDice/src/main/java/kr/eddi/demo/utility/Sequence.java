package kr.eddi.demo.utility;

import java.util.ArrayList;

public class Sequence {

    private ArrayList<Integer> sequenceList;



    /**
     * 1번의 경우 피보나치 수열을, 2번의 경우 커스텀된 수열을 출력하고 지정한 번호에 맞는 수를 가져옵니다.
     *
     * @param sequenceSelect 수열 선택
     * @param length         번호 지정
     */
    public Object sequence(int sequenceSelect, int length) {
        switch (sequenceSelect) {
            case 1:
                return fibonacchi(length);
            case 2:
                return customSeries(length);
        }
        return null;
    }

    public String fibonacchi(int length) {
        sequenceList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            switch (i) {
                case 0:
                    sequenceList.add(1);
                    break;
                case 1:
                    sequenceList.add(i);
                    break;
                default:
                    sequenceList.add(sequenceList.get(i - 1) + sequenceList.get(i - 2));
            }
        }
        return String.valueOf(sequenceList) + String.valueOf(sequenceList.get(length - 1));
    }

    public String customSeries(int length) {
        sequenceList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            switch (i) {
                case 0:
                    sequenceList.add(1);
                    break;
                case 1:
                    sequenceList.add(1);
                    break;
                case 2:
                    sequenceList.add(1);
                    break;
                default:
                    sequenceList.add(sequenceList.get(i - 1) + sequenceList.get(i - 3));
            }
        }
        return String.valueOf(sequenceList) + String.valueOf(sequenceList.get(length - 1));
    }
}


