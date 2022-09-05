package kr.eddi.demo.utility.fourth;

public class TotalSum extends DisplayNumbers {



    /**
     * 1~100 까지의 숫자 총합을 구하는 메서드
     * @return
     */
    public int multipleSum() {
        this.displayNums(1, 100);
        return numList.stream().mapToInt(Integer::intValue).sum();
    }


    /**
     * 최소값과 최대값을 설정하여 범위 내에 존재하는 지정된 숫자의 배수의 총합을 구하는 메서드
     * @param min 최소
     * @param max 최대
     * @param multiple 배수
     * @return
     */
    public int multipleSum(int min, int max, int multiple) {
        displayNums(min, max, multiple);
        return numList.stream().mapToInt(Integer::intValue).sum();
    }



    public int moveNumbersSum(int min, int max, int moveNum) {
        displayMoveNumbers(min, max, moveNum);
        return numList.stream().mapToInt(Integer::intValue).sum();
    }

}



