package kr.eddi.demo.controller.homework.fourth;

public class SecondQuestion {
    public static void main(String[] args) {
        int num = 20;
        System.out.print("수열의" + num + "번째 항 : " + count(num));
    }

    public static int count(int num) {
        if (num <= 1) {
            return num;
        } else {
            return count(num-1) + count(num-2);
        }
    }
}