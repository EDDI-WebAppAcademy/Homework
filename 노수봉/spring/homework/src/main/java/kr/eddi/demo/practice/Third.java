package kr.eddi.demo.practice;

public class Third {
    public static void main(String[] args) {
        int [] num = new int[25];

       num[0] = 1;
       num[1] = 1;
       num[2] = 1;

        for (int i = 3; i < num.length; i++) {
            num[i] = num[i-1] + num[i-3];
        }
        System.out.println("25번째 항의 값은 "+ num[24]);
    }

}
