package dice.test.reviewExample.schoolBells.run;

import dice.test.reviewExample.schoolBells.entity.SyllableNames;

public class SchoolBells {
    public static void main(String[] args) {
        System.out.println("<<학교종이 땡땡땡>>");

        runSchoolBells();
    }

    public static void runSchoolBells() {
        multipleSol();
        multipleRa();

        multipleSol();
        soloMi();
    }

    public static void multipleSol() {
        for (int i = 0; i < 2; i++) {
            System.out.print(SyllableNames.SOL.getName());
        }
    }

    public static void multipleRa() {
        for (int i = 0; i < 2; i++) {
            System.out.print(SyllableNames.RA.getName());
        }
        System.out.print("\t");
    }

    public static void soloMi() {
        System.out.println(SyllableNames.MI.getName());
    }



}
