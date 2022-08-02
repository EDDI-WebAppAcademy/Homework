package kr.eddi.demo.utility;

import java.util.ArrayList;

public class DisplayNumbers {


    protected ArrayList<Integer> numList;

    /**
     * 최소값과 최대값을 받아 그 사이의 숫차 리스트를 출력합니다
     *
     * @param min 최소값
     * @param max 최대값
     * @return
     */

    public String displayNums(int min, int max) {
        numList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numList.add(i);
        }
        return String.valueOf(numList);
    }


    /**
     * 최소값과 최대값을 받아 범위 내에 존재하는 지정한 숫자의 배수를 구합니다
     *
     * @param min      최소값
     * @param max      최대값
     * @param multiple 배수
     * @return
     */

    public String displayNums(int min, int max, int multiple) {
        numList = new ArrayList<>();
        for (int i = min; i <= max; i++ ) {
            if(i % multiple == 0) {
                numList.add(i);
            }
        }
       return String.valueOf(numList);
    }

    /**
     * 최소값과 최대값을 받아 범위 내에서 지정한 숫자만큼 이동하였을 때의 숫자들을 구합니다.
     *
     * @param min     최소값
     * @param max     최대값
     * @param moveNum 이동할 숫자
     * @return
     */
    public String displayMoveNumbers(int min, int max, int moveNum) {
        numList = new ArrayList<>();
        for (int i = min; i <= max; i += moveNum) {
            numList.add(i);
        }
        return String.valueOf(numList);
    }


    /**
     * 지정한 숫자의 구구단을 출력합니다.
     * 몇단까지 출력할지를 설정해줍니다.
     * @param multiple
     * @param end 단
     */

    public String multiTable(int multiple, int end) {
        numList = new ArrayList<>();
        ArrayList<String> multitableList = new ArrayList<>();
        System.out.printf("%d단\n", multiple);
        for (int i = 1; i <= end; i++) {
            numList.add(i * multiple);
            multitableList.add(String.format("%d * %d = %d\n", multiple, i, numList.get(i-1)));
        }
        return String.valueOf(multitableList);
    }
}



