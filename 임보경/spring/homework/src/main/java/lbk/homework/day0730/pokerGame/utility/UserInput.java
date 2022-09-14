package lbk.homework.day0730.pokerGame.utility;

import java.util.Scanner;

public class UserInput {
    public static Scanner scan = new Scanner(System.in);
    public static Integer selectedNumber;

    public static void inputIntKeyBoard(){
        selectedNumber = scan.nextInt();
    }

    public static Integer getSelectedNumber(){
        return selectedNumber;
    }
}
