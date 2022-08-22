package questionBank.practice2;

import java.util.ArrayList;

public class Tenth {
//    10. 1 ~ 100까지의 숫자를 순회한다.
//        9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
//        다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
//        이동했을때 나온 숫자들의 합을 계산하도록 만들어보자!
    private static final int loopStopNum = 5;

    public static void main(String[] args) {

        ArrayList<Integer> nextNumArr = new ArrayList<>();

        int nextNumSum = 0;
        for (int i = 0 ; i < loopStopNum; i++) {
            //nextNumArr이 비워져 있으면 첫 번째 값 저장
            if(nextNumArr.isEmpty()){
                int ranNum = Eighth.multipleNum(2, 10);
                System.out.println("랜덤 숫자 : " + ranNum);
                nextNumArr.add(Eighth.allNumber()[ranNum]);
                nextNumSum += nextNumArr.get(i);
            //아니면 앞 인덱스 값 + 새로운 랜덤 값
            // 랜덤한 숫자만큼 이동하기 때문에 기존 값에서 더 해져야함
            }else {
                int ranNum = Eighth.multipleNum(2, 10);
                System.out.println("랜덤 숫자 " + ranNum +"만큼 이동");
                nextNumArr.add(nextNumArr.get(i - 1)
                        + (Eighth.allNumber()[ranNum]));
                nextNumSum += nextNumArr.get(i);
            }
            }
        System.out.println("nextNum = " + nextNumArr);
        System.out.println("합계 : " + nextNumSum);
    }





}
