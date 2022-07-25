package fourth.question2.q8_9_10;

public class RandomNum {

    private static final int min = 1;
    private static final int max = 100;
    private static final int randomMin = 2;
    private static final int randomMax = 10;
    private static int randomNum;

    //8번 문제- 랜덤 배수 생성 메소드
    // min, max 값 포함되는 랜덤 숫자 구하기 -> (int) Math.random() * (max - min + 1) + min
    public static void MakeRandomNum(){

        randomNum = (int) (Math.random() * (randomMax - randomMin +1) + randomMin);  // 2 ~ 10 사이 값 랜덤숫자 생성
        System.out.println("랜덤 배수로 " + randomNum + "가(이) 나왔습니다.");
    }


    //8번 문제- 랜덤 배수(2~10)에 따른 배수 결과값 (1~100 범위 내) 생성 메소드
    public static void MakeRandomResult(){

        System.out.println(min + "과 "+ max + " 범위 내 " + randomNum + "의 배수는 다음과 같습니다.");

        for (int i = min; i <= max; i++) {
            if((i % randomNum) == 0) {
                System.out.println(i);
            }
        }
    }

    //9번 문제 - (랜덤 배수 생성 + 결과값) * 이중 반복 -> 배수 총 합 계산 메소드
    public static void MakeRandomResultLoop(){

        int sum1 = 0;
        int sum2 = 0;
        int total = 0;

        MakeRandomNum();                     // 중복되는 부분 배열로?
        for (int i = min; i < max; i++) {
            if((i % randomNum) == 0) {
                sum1 += i;
            }
        }

        MakeRandomNum();
        for (int j = min; j <= max; j++) {
            if((j % randomNum) == 0) {
               sum2 += j;
                }
            }

        total = sum1 + sum2;
        System.out.println("랜덤 숫자의 배수 합은 "+ total +"입니다.");
    }


    //10번 문제 - 랜덤 배수 생성 후 배수만큼 이동 > 배수 합 메소드
    public static void MakeRandomResultSum(){

        int sum = 0;

        MakeRandomNum();
        for (int i = min; i < max; i++) {
            if((i % randomNum) == 0) {
                sum += i;
                System.out.println(i);
            }
        }

        System.out.println("랜덤 숫자의 배수 합은 "+ sum +"입니다.");
    }


}



//8. 1 ~ 100까지 숫자를 순회한다.
//
//   2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤



//9. 1 ~ 100까지의 숫자를 순회한다.
//    2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
//    다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
//    그 다음 루프에서 다시 작업을 반복한다.
//    끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤



// 10. 1 ~ 100까지의 숫자를 순회한다.
//     9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
//     다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
//     이동했을때 나온 숫자들의 합을 계산하도록 만들어보자!
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤