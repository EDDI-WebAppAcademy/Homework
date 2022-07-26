package kr.eddi.demo.entity.basic.fourth;

//문제
//2번 문제- 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!
//
//3번 문제 - 1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
//   이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!


//# Success criteria
//
//1. 임의의 수열이 와도 처리할 준비가 설계 차원에서 되어 있음
//2. n번째 데이터를 찾을 수 있어야함
//3. 새로운 규칙을 가진 수열이 나타나더라도 일관된 방식으로 찾을 수 있어야함

//import kr.eddi.demo.entity.basic.fourth.Series;
//- [x]  수열 클래스 작성
//- [x]  n번째 항을 찾는 매서드 작성
//- [x]  수열 생성 규칙을 가진 생성자 작성


// 1. 내가 어떤 정보를 이 클래스를 통해 제어하려고 하는가 ? 수열
// 2. 이 정보에 영향을 미칠 수 있는 인자는 어떤것들이 있는가 ? 수열 패턴, 수열 개수

public class Series {

    private final int FIBONACCI_SERIES = 1;
    private final int CUSTOM_SERIES = 2;
    private int[] seriesArr;

    // 생성자에서 수열의 종류(seriesNum)와 길이(length)를 받음

    public Series(int seriesNum, int length) {
        seriesArr = new int[length];

        if (seriesNum == FIBONACCI_SERIES) {
            makeFibonacciSeries();
        } else if (seriesNum == CUSTOM_SERIES) {
            makeCustomSeries();
        } else {
            System.out.println("잘못된 정보입니다!");
        }
    }

    public void makeFibonacciSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;

        for (int i = 2; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 1] + seriesArr[i - 2];
        }
    }

    public void makeCustomSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;
        seriesArr[2] = 1;
        seriesArr[3] = 2;

        for (int i = 4; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 2] + seriesArr[i - 3] + seriesArr[i - 4];
        }
    }

    //실제 결과 값 돌려주는 메소드
    public int findSeriesNum() {
        return seriesArr[seriesArr.length - 1];  // 메소드 종류와 길이 받아서
    }

}
