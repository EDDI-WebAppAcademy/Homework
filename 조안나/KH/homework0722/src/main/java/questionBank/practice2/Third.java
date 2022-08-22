package questionBank.practice2;

public class Third {
//    1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
//    이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!

   private static final int INDEX = 20;
    public static void main(String[] args) {
    //인덱스가 0부터 시작한다 치면, 인덱스 0 + 2번의 값이 첫 번째 값이 된다.

        int[] result = new int[INDEX + 1];

        for (int i = 0; i <= INDEX; i++) {
            if (result[2] == 0){
                result[i] = 1;
            } else {
                int num = (result[i - 3]) + (result[i - 1]);
                result[i] = num;
            }
            System.out.println("result : " + result[i]);
        }
        System.out.println();
        System.out.println(INDEX + "번째 값 : " + result[INDEX - 1]);
    }
}
