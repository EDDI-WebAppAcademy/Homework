package com.example.demo.utillity.basic.poker;

import java.util.Scanner;

public class UserInput {
    public static Scanner scan = new Scanner(System.in);
    public static Integer selectedNumber;


    /**
     * 플레이어부터 키보드로 숫자를 입력받는 메서드 <br>
     * Integer selectedNumber에 저장
     */
    public static void inputIntKeyBoard() {
        selectedNumber = scan.nextInt();
    }

    /**
     * 입력받은 숫자를 반환하는 메서드
     * @return selectedNumber
     */
    public static Integer getSelectedNumber() {
        return selectedNumber;
    }
}
