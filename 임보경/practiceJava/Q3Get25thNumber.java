package javaBasic;

/*
* 1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
   이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!
* */
public class Q3Get25thNumber {
    public static void main(String[] args) {
        int[] arr = new int[25];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        /*
        * 2[i] -1[i-1] = 1[i-3]
        * 3[i]- 2[i-1] = 1[i-3]
        * 4- 3 = 1
        * 6- 4 = 2
        * 9- 6 = 3
        * 13 - 9 = 4
        * 19 - 13 = 6
        * */
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
            System.out.println(arr[i]);
        }

        System.out.println("25번째 숫자는 : " + arr[24]);

    }


}
