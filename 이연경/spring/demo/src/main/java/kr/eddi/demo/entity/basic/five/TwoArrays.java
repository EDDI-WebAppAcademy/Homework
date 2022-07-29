package kr.eddi.demo.entity.basic.five;


public class TwoArrays {

    // [문제은행 4-1] 이중배열 초기화 후 아무값 대입
    // [문제은행 4-2] 1번 문제에서 초기화한 배열 출력

    public String twoArrays() {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}

        };


        for (int i = 0; i < arr.length; i++) {

            int[] inArr = arr[i];

            for (int x = 0; x < inArr.length; x++) {

                System.out.println(inArr[x] + "");
            }
            System.out.println();
        }

        return "arr 배열을 출력하기 " + arr;
    }


}


