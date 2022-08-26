package questionBank.practice2;

public class Fourth {
//    4. 구구단 7단을 출력해보자!

    private static final int DAN = 7;

    public static void main(String[] args) {

        System.out.println("***구구단 " + DAN +"단!***");
        for (int i = 1; i <= 9; i++) {
            System.out.println(DAN + " * " + i +" = " + (DAN * i));
        }
    }
}
