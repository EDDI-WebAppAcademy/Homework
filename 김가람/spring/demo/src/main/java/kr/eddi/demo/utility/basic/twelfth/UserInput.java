package kr.eddi.demo.utility.basic.twelfth;

import java.util.Scanner;

public class UserInput {
    public static Scanner scan = new Scanner(System.in);
    public static Integer selectedNumber;

    public static void inputIntKeyBoard() {
        selectedNumber = scan.nextInt();
    }

    public static Integer getSelectedNumber() { // int면 안되나?
        return selectedNumber;
    }
}
