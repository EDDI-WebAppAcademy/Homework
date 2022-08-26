package practice.bank4.quiz1;

import java.util.Arrays;

public class Cat {

    public static void main(String[] args) {
        printCats();
    }
    private static String[][] cats = {
            {"냥이","2살"}, {"나비","7살"}
    };

    private static void printCats(){
        for (int i = 0; i < cats.length; i++) {
            for (int j = 0; j < cats[i].length; j++) {
                System.out.print(cats[i][j] + "\t");
            }
        }
    }



}
