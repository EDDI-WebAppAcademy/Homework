package kr.eddi.demo.utility.ten;

import org.apache.tomcat.util.security.Escape;

import java.util.Scanner;

public class UserInput {
    public static Scanner sc = new Scanner(System.in);
    public static Integer selectNumber;

    public static void inputKeyBoard() {
        selectNumber = sc.nextInt();
    }

    public static Integer getSelectNumber() {
        return selectNumber;
    }
}
